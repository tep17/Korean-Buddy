package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.filled.Style
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.LearningLanguage
import com.example.model.QuestionType
import com.example.ui.AppDestination
import com.example.ui.MainViewModel
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGold
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

data class PracticeActivity(
    val id: String,
    val titleEn: String,
    val titleFil: String,
    val descriptionEn: String,
    val descriptionFil: String,
    val icon: ImageVector,
    val color: Color,
    val destination: AppDestination
)

@Composable
fun PracticeScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.selectedLanguage.collectAsState()
    val missedQuestions by viewModel.missedQuestions.collectAsState()

    val activities = listOf(
        PracticeActivity(
            id = "act_daily",
            titleEn = "Daily Challenge",
            titleFil = "Arawang Pagsubok",
            descriptionEn = "Comprehensive mix of Vocab, Hangul, Listening & Sentences.",
            descriptionFil = "Koleksyon ng bokabularyo, Hangul, pakikinig, at pangungusap.",
            icon = Icons.Default.Today,
            color = KoreanGold,
            destination = AppDestination.DailyChallengeMode
        ),
        PracticeActivity(
            id = "act_flashcards",
            titleEn = "Spaced Repetition Flashcards",
            titleFil = "Flashcards at Pagsasanay",
            descriptionEn = "Review vocabulary with Easy, Good, and Difficult intervals.",
            descriptionFil = "Balikan ang mga salita gamit ang matalinong pag-uulit.",
            icon = Icons.Default.Style,
            color = KoreanBluePrimary,
            destination = AppDestination.FlashcardsMode
        ),
        PracticeActivity(
            id = "act_conversation",
            titleEn = "Conversation Simulation",
            titleFil = "Pagsasanay sa Pakikipag-usap",
            descriptionEn = "Interactive dialogues at restaurants, cafes, and subway stations.",
            descriptionFil = "Interaktibong usapan sa restawran, kapehan, at istasyon.",
            icon = Icons.Default.Chat,
            color = KoreanJade,
            destination = AppDestination.ConversationView("conv_restaurant")
        ),
        PracticeActivity(
            id = "act_listening",
            titleEn = "Listening Practice",
            titleFil = "Pagsasanay sa Pakikinig",
            descriptionEn = "Hear Korean native audio and identify syllables and words.",
            descriptionFil = "Makinig sa Korean audio at tukuyin ang tamang pantig.",
            icon = Icons.Default.Hearing,
            color = KoreanBluePrimary,
            destination = AppDestination.PracticeMode(QuestionType.LISTENING)
        ),
        PracticeActivity(
            id = "act_mcq",
            titleEn = "Multiple Choice Meaning Quiz",
            titleFil = "Pagsusulit sa Kahulugan",
            descriptionEn = "Test your grasp of Korean words and expressions.",
            descriptionFil = "Subukan ang iyong kaalaman sa kahulugan ng salita.",
            icon = Icons.Default.Quiz,
            color = KoreanRedAccent,
            destination = AppDestination.PracticeMode(QuestionType.MULTIPLE_CHOICE)
        ),
        PracticeActivity(
            id = "act_hangul",
            titleEn = "Hangul Sound Recognition",
            titleFil = "Pagkilala sa Tunog ng Hangul",
            descriptionEn = "Recognize consonants, vowels, and double consonants.",
            descriptionFil = "Kilalanin ang mga tunog ng katinig at patinig.",
            icon = Icons.Default.FontDownload,
            color = KoreanJade,
            destination = AppDestination.PracticeMode(QuestionType.HANGUL_RECOGNITION)
        ),
        PracticeActivity(
            id = "act_sentence",
            titleEn = "Sentence Builder & Arrange",
            titleFil = "Pagsasaayos ng Pangungusap",
            descriptionEn = "Arrange scrambled Korean syllables into correct sentences.",
            descriptionFil = "Ayusin ang mga pira-pirasong pantig sa tamang ayos.",
            icon = Icons.Default.Reorder,
            color = KoreanGold,
            destination = AppDestination.PracticeMode(QuestionType.SENTENCE_BUILD)
        )
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = when (language) {
                    LearningLanguage.FILIPINO -> "Sentro ng Pagsasanay"
                    LearningLanguage.KOREAN -> "한국어 연습 센터"
                    else -> "Interactive Practice Center"
                },
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Quizzes, listening drills, dialogues & spaced repetition.",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }

        // Missed Questions Review Banner if any
        if (missedQuestions.isNotEmpty()) {
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = KoreanRedAccent.copy(alpha = 0.15f)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.navigateTo(AppDestination.ReviewMissedQuestionsMode) }
                        .testTag("review_missed_btn")
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(KoreanRedAccent)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Review",
                                tint = Color.White,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Review Weak Areas (${missedQuestions.size})",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreanRedAccent
                                )
                            )
                            Text(
                                text = "Practice questions you missed previously until mastered.",
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Review",
                            tint = KoreanRedAccent
                        )
                    }
                }
            }
        }

        // Activities List
        items(activities) { act ->
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.navigateTo(act.destination) }
                    .testTag("practice_card_${act.id}")
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(act.color.copy(alpha = 0.15f))
                    ) {
                        Icon(
                            imageVector = act.icon,
                            contentDescription = act.titleEn,
                            tint = act.color,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = when (language) {
                                LearningLanguage.FILIPINO -> act.titleFil
                                else -> act.titleEn
                            },
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = when (language) {
                                LearningLanguage.FILIPINO -> act.descriptionFil
                                else -> act.descriptionEn
                            },
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Start",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
