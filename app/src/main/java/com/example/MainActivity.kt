package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import com.example.data.CourseData
import com.example.data.PracticeData
import com.example.model.LearningLanguage
import com.example.ui.AppDestination
import com.example.ui.MainViewModel
import com.example.ui.components.KoreanBuddyTopBar
import com.example.ui.screens.ConversationSimulationScreen
import com.example.ui.screens.FlashcardsScreen
import com.example.ui.screens.HangulBatchimGuideScreen
import com.example.ui.screens.HangulSyllableBuilderScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnContainerScreen
import com.example.ui.screens.LessonViewerScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.QuizRunnerScreen
import com.example.ui.screens.VocabularyScreen
import com.example.ui.theme.KoreanBuddyTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoreanBuddyTheme {
                MainApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainApp(viewModel: MainViewModel) {
    val currentTab by viewModel.currentTab.collectAsState()
    val destination by viewModel.destination.collectAsState()
    val language by viewModel.selectedLanguage.collectAsState()
    val isSlowAudio by viewModel.isSlowAudio.collectAsState()
    val missedQuestions by viewModel.missedQuestions.collectAsState()

    val isSubScreen = destination !is AppDestination.Main

    BackHandler(enabled = isSubScreen) {
        viewModel.navigateBack()
    }

    val topBarTitle = when (destination) {
        is AppDestination.Main -> when (currentTab) {
            0 -> "Korean Buddy"
            1 -> when (language) {
                LearningLanguage.FILIPINO -> "Mag-aral ng Korean"
                LearningLanguage.KOREAN -> "한국어 배우기"
                else -> "Learn Korean"
            }
            2 -> when (language) {
                LearningLanguage.FILIPINO -> "Magsanay"
                LearningLanguage.KOREAN -> "연습 센터"
                else -> "Practice Center"
            }
            3 -> when (language) {
                LearningLanguage.FILIPINO -> "Bokabularyo"
                LearningLanguage.KOREAN -> "한국어 단어장"
                else -> "Vocabulary Builder"
            }
            else -> when (language) {
                LearningLanguage.FILIPINO -> "Aking Profile"
                LearningLanguage.KOREAN -> "내 프로필"
                else -> "My Profile"
            }
        }
        is AppDestination.HangulSyllableBuilder -> "Syllable Builder"
        is AppDestination.HangulBatchimGuide -> "Batchim Guide"
        is AppDestination.LessonView -> "Lesson Details"
        is AppDestination.ConversationView -> "Conversation Dialogue"
        is AppDestination.FlashcardsMode -> "Flashcards (SRS)"
        is AppDestination.DailyChallengeMode -> "Daily Challenge"
        is AppDestination.PracticeMode -> "Practice Quiz"
        is AppDestination.ReviewMissedQuestionsMode -> "Review Mistakes"
        else -> "Korean Buddy"
    }

    val navItems = listOf(
        NavigationItem("Home", "Tahanan", "홈", Icons.Filled.Home, Icons.Outlined.Home, "nav_tab_home"),
        NavigationItem("Learn", "Aralin", "학습", Icons.Filled.School, Icons.Outlined.School, "nav_tab_learn"),
        NavigationItem("Practice", "Pagsasanay", "연습", Icons.Filled.FitnessCenter, Icons.Outlined.FitnessCenter, "nav_tab_practice"),
        NavigationItem("Vocab", "Salita", "단어", Icons.Filled.Book, Icons.Outlined.Book, "nav_tab_vocab"),
        NavigationItem("Profile", "Profile", "프로필", Icons.Filled.Person, Icons.Outlined.Person, "nav_tab_profile")
    )

    Scaffold(
        topBar = {
            KoreanBuddyTopBar(
                title = topBarTitle,
                subtitle = if (!isSubScreen && currentTab == 0) "Learn Korean with English & Filipino" else null,
                currentLanguage = language,
                onLanguageChange = { viewModel.setLanguage(it) },
                isSlowAudio = isSlowAudio,
                onToggleSlowAudio = { viewModel.toggleSlowAudio() },
                showBackButton = isSubScreen,
                onBackClick = { viewModel.navigateBack() }
            )
        },
        bottomBar = {
            if (!isSubScreen) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    navItems.forEachIndexed { index, item ->
                        val isSelected = currentTab == index
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { viewModel.setTab(index) },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.labelEn
                                )
                            },
                            label = {
                                Text(
                                    text = when (language) {
                                        LearningLanguage.FILIPINO -> item.labelFil
                                        LearningLanguage.KOREAN -> item.labelKo
                                        else -> item.labelEn
                                    },
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            modifier = Modifier.testTag(item.testTag)
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val dest = destination) {
                is AppDestination.Main -> {
                    when (currentTab) {
                        0 -> HomeScreen(viewModel = viewModel)
                        1 -> LearnContainerScreen(viewModel = viewModel)
                        2 -> PracticeScreen(viewModel = viewModel)
                        3 -> VocabularyScreen(viewModel = viewModel)
                        4 -> ProfileScreen(viewModel = viewModel)
                    }
                }
                is AppDestination.HangulSyllableBuilder -> HangulSyllableBuilderScreen(viewModel = viewModel)
                is AppDestination.HangulBatchimGuide -> HangulBatchimGuideScreen(viewModel = viewModel)
                is AppDestination.LessonView -> LessonViewerScreen(lesson = dest.lesson, viewModel = viewModel)
                is AppDestination.ConversationView -> ConversationSimulationScreen(conversationId = dest.convId, viewModel = viewModel)
                is AppDestination.FlashcardsMode -> FlashcardsScreen(viewModel = viewModel)
                is AppDestination.DailyChallengeMode -> QuizRunnerScreen(
                    title = "Daily Challenge",
                    questions = PracticeData.dailyChallengeQuestions,
                    viewModel = viewModel
                )
                is AppDestination.PracticeMode -> {
                    // Filter or use questions appropriate for the practice type
                    val questions = when (dest.type) {
                        com.example.model.QuestionType.LISTENING -> PracticeData.dailyChallengeQuestions.filter { it.type == com.example.model.QuestionType.LISTENING }
                        com.example.model.QuestionType.HANGUL_RECOGNITION -> PracticeData.dailyChallengeQuestions.filter { it.type == com.example.model.QuestionType.HANGUL_RECOGNITION }
                        com.example.model.QuestionType.SENTENCE_BUILD -> PracticeData.dailyChallengeQuestions.filter { it.type == com.example.model.QuestionType.SENTENCE_BUILD || it.type == com.example.model.QuestionType.WORD_ARRANGE }
                        else -> CourseData.allLessons.flatMap { it.quiz }
                    }.ifEmpty { PracticeData.dailyChallengeQuestions }

                    QuizRunnerScreen(
                        title = dest.type.name.replace("_", " "),
                        questions = questions,
                        viewModel = viewModel
                    )
                }
                is AppDestination.ReviewMissedQuestionsMode -> {
                    val allQuestions = CourseData.allLessons.flatMap { it.quiz } + PracticeData.dailyChallengeQuestions
                    val missed = allQuestions.filter { missedQuestions.contains(it.id) }.ifEmpty { PracticeData.dailyChallengeQuestions.take(3) }
                    QuizRunnerScreen(
                        title = "Weak Areas Review",
                        questions = missed,
                        viewModel = viewModel
                    )
                }
                else -> HomeScreen(viewModel = viewModel)
            }
        }
    }
}

data class NavigationItem(
    val labelEn: String,
    val labelFil: String,
    val labelKo: String,
    val selectedIcon: androidx.compose.ui.graphics.vector.ImageVector,
    val unselectedIcon: androidx.compose.ui.graphics.vector.ImageVector,
    val testTag: String
)
