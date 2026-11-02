package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey val id: Int = 1,
    val completedLessonIds: String = "", // comma-separated
    val streakDays: Int = 1,
    val lastActiveDate: String = "",
    val totalStudyMinutes: Int = 15,
    val quizzesTaken: Int = 0,
    val quizCorrectCount: Int = 0,
    val selectedLanguage: String = "en", // "en", "fil", "ko"
    val isSlowAudio: Boolean = false,
    val dailyGoalLessons: Int = 2,
    val todayLessonsCompleted: Int = 0,
    val todayDate: String = ""
)

@Entity(tableName = "vocab_progress")
data class VocabProgressEntity(
    @PrimaryKey val wordId: String,
    val isFavorite: Boolean = false,
    val srsLevel: Int = 0, // 0 = new, 1 = learning, 2 = review, 3 = mastered
    val lastReviewTimestamp: Long = 0L
)

@Entity(tableName = "quiz_mistakes")
data class QuizMistakeEntity(
    @PrimaryKey val questionId: String,
    val missCount: Int = 1,
    val lastMissedTimestamp: Long = System.currentTimeMillis()
)
