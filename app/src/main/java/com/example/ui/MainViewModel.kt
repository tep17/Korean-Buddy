package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.audio.TTSManager
import com.example.data.CourseData
import com.example.data.HangulData
import com.example.data.PracticeData
import com.example.data.VocabularyData
import com.example.data.local.AppDatabase
import com.example.data.local.QuizMistakeEntity
import com.example.data.local.UserProgressEntity
import com.example.data.local.VocabProgressEntity
import com.example.model.Achievement
import com.example.model.CourseLevelId
import com.example.model.HangulCharacter
import com.example.model.LearningLanguage
import com.example.model.Lesson
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.model.VocabularyItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

sealed class AppDestination {
    object Main : AppDestination()
    data class HangulDetail(val character: HangulCharacter) : AppDestination()
    object HangulSyllableBuilder : AppDestination()
    object HangulBatchimGuide : AppDestination()
    data class LessonView(val lesson: Lesson) : AppDestination()
    data class PracticeMode(val type: QuestionType) : AppDestination()
    data class ConversationView(val convId: String) : AppDestination()
    object FlashcardsMode : AppDestination()
    object DailyChallengeMode : AppDestination()
    object ReviewMissedQuestionsMode : AppDestination()
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    val ttsManager = TTSManager(application)

    private val _currentTab = MutableStateFlow(0)
    val currentTab: StateFlow<Int> = _currentTab.asStateFlow()

    private val _destination = MutableStateFlow<AppDestination>(AppDestination.Main)
    val destination: StateFlow<AppDestination> = _destination.asStateFlow()

    // Navigation backstack
    private val backstack = mutableListOf<AppDestination>()

    // User preferences & progress
    private val _selectedLanguage = MutableStateFlow(LearningLanguage.ENGLISH)
    val selectedLanguage: StateFlow<LearningLanguage> = _selectedLanguage.asStateFlow()

    private val _isSlowAudio = MutableStateFlow(false)
    val isSlowAudio: StateFlow<Boolean> = _isSlowAudio.asStateFlow()

    private val _completedLessonIds = MutableStateFlow<Set<String>>(emptySet())
    val completedLessonIds: StateFlow<Set<String>> = _completedLessonIds.asStateFlow()

    private val _streakDays = MutableStateFlow(1)
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    private val _totalStudyMinutes = MutableStateFlow(24)
    val totalStudyMinutes: StateFlow<Int> = _totalStudyMinutes.asStateFlow()

    private val _quizzesTaken = MutableStateFlow(0)
    val quizzesTaken: StateFlow<Int> = _quizzesTaken.asStateFlow()

    private val _quizCorrectCount = MutableStateFlow(0)
    val quizCorrectCount: StateFlow<Int> = _quizCorrectCount.asStateFlow()

    private val _dailyGoal = MutableStateFlow(2)
    val dailyGoal: StateFlow<Int> = _dailyGoal.asStateFlow()

    private val _todayCompletedLessons = MutableStateFlow(0)
    val todayCompletedLessons: StateFlow<Int> = _todayCompletedLessons.asStateFlow()

    private val _favorites = MutableStateFlow<Set<String>>(emptySet())
    val favorites: StateFlow<Set<String>> = _favorites.asStateFlow()

    private val _srsLevels = MutableStateFlow<Map<String, Int>>(emptyMap())
    val srsLevels: StateFlow<Map<String, Int>> = _srsLevels.asStateFlow()

    private val _missedQuestions = MutableStateFlow<Set<String>>(emptySet())
    val missedQuestions: StateFlow<Set<String>> = _missedQuestions.asStateFlow()

    // Search query in vocabulary
    private val _vocabSearchQuery = MutableStateFlow("")
    val vocabSearchQuery: StateFlow<String> = _vocabSearchQuery.asStateFlow()

    init {
        loadPersistedData()
    }

    private fun loadPersistedData() {
        viewModelScope.launch {
            db.userProgressDao().getUserProgress().collect { progress ->
                if (progress != null) {
                    _selectedLanguage.value = when (progress.selectedLanguage) {
                        "fil" -> LearningLanguage.FILIPINO
                        "ko" -> LearningLanguage.KOREAN
                        else -> LearningLanguage.ENGLISH
                    }
                    _isSlowAudio.value = progress.isSlowAudio
                    _streakDays.value = progress.streakDays
                    _totalStudyMinutes.value = progress.totalStudyMinutes
                    _quizzesTaken.value = progress.quizzesTaken
                    _quizCorrectCount.value = progress.quizCorrectCount
                    _dailyGoal.value = progress.dailyGoalLessons

                    val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                    if (progress.todayDate == today) {
                        _todayCompletedLessons.value = progress.todayLessonsCompleted
                    } else {
                        _todayCompletedLessons.value = 0
                    }

                    if (progress.completedLessonIds.isNotBlank()) {
                        _completedLessonIds.value = progress.completedLessonIds.split(",").toSet()
                    }
                } else {
                    // Seed initial default progress
                    val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                    db.userProgressDao().insertOrUpdate(
                        UserProgressEntity(
                            id = 1,
                            completedLessonIds = "l1_1",
                            streakDays = 3,
                            lastActiveDate = today,
                            totalStudyMinutes = 25,
                            todayDate = today,
                            todayLessonsCompleted = 1
                        )
                    )
                    _completedLessonIds.value = setOf("l1_1")
                    _streakDays.value = 3
                    _todayCompletedLessons.value = 1
                }
            }
        }

        viewModelScope.launch {
            db.vocabProgressDao().getAllVocabProgress().collect { list ->
                val favs = mutableSetOf<String>()
                val srs = mutableMapOf<String, Int>()
                list.forEach {
                    if (it.isFavorite) favs.add(it.wordId)
                    srs[it.wordId] = it.srsLevel
                }
                _favorites.value = favs
                _srsLevels.value = srs
            }
        }

        viewModelScope.launch {
            db.quizMistakeDao().getAllMistakes().collect { list ->
                _missedQuestions.value = list.map { it.questionId }.toSet()
            }
        }
    }

    fun setLanguage(language: LearningLanguage) {
        _selectedLanguage.value = language
        saveUserProgress()
    }

    fun toggleSlowAudio() {
        _isSlowAudio.value = !_isSlowAudio.value
        saveUserProgress()
    }

    fun speak(text: String) {
        ttsManager.speak(text, isSlow = _isSlowAudio.value)
    }

    fun setTab(index: Int) {
        _currentTab.value = index
        _destination.value = AppDestination.Main
        backstack.clear()
    }

    fun navigateTo(dest: AppDestination) {
        backstack.add(_destination.value)
        _destination.value = dest
    }

    fun navigateBack(): Boolean {
        if (backstack.isNotEmpty()) {
            _destination.value = backstack.removeAt(backstack.size - 1)
            return true
        } else if (_destination.value !is AppDestination.Main) {
            _destination.value = AppDestination.Main
            return true
        }
        return false
    }

    fun completeLesson(lessonId: String) {
        val newSet = _completedLessonIds.value + lessonId
        _completedLessonIds.value = newSet
        _todayCompletedLessons.value = _todayCompletedLessons.value + 1
        _totalStudyMinutes.value = _totalStudyMinutes.value + 8
        saveUserProgress()
    }

    fun toggleFavorite(wordId: String) {
        val isFav = _favorites.value.contains(wordId)
        val newFav = !isFav
        val newSet = if (newFav) _favorites.value + wordId else _favorites.value - wordId
        _favorites.value = newSet

        viewModelScope.launch {
            val existing = db.vocabProgressDao().getVocabProgress(wordId)
            if (existing != null) {
                db.vocabProgressDao().updateFavorite(wordId, newFav)
            } else {
                db.vocabProgressDao().insertOrUpdate(
                    VocabProgressEntity(wordId = wordId, isFavorite = newFav)
                )
            }
        }
    }

    fun updateSrsGrade(wordId: String, grade: Int) { // 0 = Hard, 1 = Good, 2 = Easy
        val current = _srsLevels.value[wordId] ?: 0
        val next = when (grade) {
            2 -> (current + 1).coerceAtMost(3) // Easy
            1 -> current // Good
            else -> (current - 1).coerceAtLeast(0) // Hard
        }
        val map = _srsLevels.value.toMutableMap()
        map[wordId] = next
        _srsLevels.value = map

        viewModelScope.launch {
            db.vocabProgressDao().insertOrUpdate(
                VocabProgressEntity(
                    wordId = wordId,
                    isFavorite = _favorites.value.contains(wordId),
                    srsLevel = next,
                    lastReviewTimestamp = System.currentTimeMillis()
                )
            )
        }
    }

    fun recordQuizResult(questionId: String, isCorrect: Boolean) {
        _quizzesTaken.value = _quizzesTaken.value + 1
        if (isCorrect) {
            _quizCorrectCount.value = _quizCorrectCount.value + 1
            viewModelScope.launch {
                db.quizMistakeDao().removeMistake(questionId)
            }
        } else {
            viewModelScope.launch {
                db.quizMistakeDao().recordMistake(
                    QuizMistakeEntity(questionId = questionId)
                )
            }
        }
        saveUserProgress()
    }

    fun setVocabSearchQuery(query: String) {
        _vocabSearchQuery.value = query
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            db.userProgressDao().insertOrUpdate(
                UserProgressEntity(
                    id = 1,
                    completedLessonIds = "",
                    streakDays = 1,
                    lastActiveDate = today,
                    totalStudyMinutes = 0,
                    quizzesTaken = 0,
                    quizCorrectCount = 0,
                    todayDate = today,
                    todayLessonsCompleted = 0
                )
            )
            db.quizMistakeDao().clearAllMistakes()
            _completedLessonIds.value = emptySet()
            _streakDays.value = 1
            _totalStudyMinutes.value = 0
            _quizzesTaken.value = 0
            _quizCorrectCount.value = 0
            _todayCompletedLessons.value = 0
            _favorites.value = emptySet()
            _srsLevels.value = emptyMap()
            _missedQuestions.value = emptySet()
        }
    }

    private fun saveUserProgress() {
        viewModelScope.launch {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val entity = UserProgressEntity(
                id = 1,
                completedLessonIds = _completedLessonIds.value.joinToString(","),
                streakDays = _streakDays.value,
                lastActiveDate = today,
                totalStudyMinutes = _totalStudyMinutes.value,
                quizzesTaken = _quizzesTaken.value,
                quizCorrectCount = _quizCorrectCount.value,
                selectedLanguage = _selectedLanguage.value.code,
                isSlowAudio = _isSlowAudio.value,
                dailyGoalLessons = _dailyGoal.value,
                todayLessonsCompleted = _todayCompletedLessons.value,
                todayDate = today
            )
            db.userProgressDao().insertOrUpdate(entity)
        }
    }

    fun getAchievements(): List<Achievement> {
        val completedCount = _completedLessonIds.value.size
        val masteredVocabCount = _srsLevels.value.count { it.value >= 2 }
        val lang = _selectedLanguage.value

        return listOf(
            Achievement(
                id = "ach_first_lesson",
                titleEn = "First Step",
                titleFil = "Unang Hakbang",
                descEn = "Complete your very first Korean lesson.",
                descFil = "Kumpletuhin ang iyong pinakaunang aralin sa Korean.",
                iconEmoji = "🌱",
                isUnlocked = completedCount >= 1,
                progress = (completedCount.toFloat() / 1f).coerceAtMost(1f)
            ),
            Achievement(
                id = "ach_hangul_starter",
                titleEn = "Hangul Pioneer",
                titleFil = "Tagapanguna sa Hangul",
                descEn = "Learn Hangul alphabet basics and syllable rules.",
                descFil = "Pag-aralan ang mga patinig at katinig ng Hangul.",
                iconEmoji = "🔤",
                isUnlocked = completedCount >= 2,
                progress = (completedCount.toFloat() / 2f).coerceAtMost(1f)
            ),
            Achievement(
                id = "ach_vocab_master",
                titleEn = "Word Collector",
                titleFil = "Kolektor ng Salita",
                descEn = "Master at least 5 vocabulary flashcards in SRS.",
                descFil = "Kabisaduhin ang 5 salita sa flashcard review.",
                iconEmoji = "📚",
                isUnlocked = masteredVocabCount >= 5,
                progress = (masteredVocabCount.toFloat() / 5f).coerceAtMost(1f)
            ),
            Achievement(
                id = "ach_streak_hero",
                titleEn = "Dedication Streak",
                titleFil = "Matiyagang Pagsasanay",
                descEn = "Maintain a 3-day active learning streak.",
                descFil = "Panatilihin ang 3 araw na sunod-sunod na pag-aaral.",
                iconEmoji = "🔥",
                isUnlocked = _streakDays.value >= 3,
                progress = (_streakDays.value.toFloat() / 3f).coerceAtMost(1f)
            ),
            Achievement(
                id = "ach_quiz_whiz",
                titleEn = "Quiz Champion",
                titleFil = "Kampeon sa Pagsusulit",
                descEn = "Answer at least 10 quiz exercises correctly.",
                descFil = "Masagot nang tama ang 10 tanong sa pagsusulit.",
                iconEmoji = "🏆",
                isUnlocked = _quizCorrectCount.value >= 10,
                progress = (_quizCorrectCount.value.toFloat() / 10f).coerceAtMost(1f)
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
    }
}
