package com.example.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.LearningLanguage
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.ui.MainViewModel
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGold
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

@Composable
fun QuizRunnerScreen(
    title: String,
    questions: List<QuizQuestion>,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val language by viewModel.selectedLanguage.collectAsState()
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }
    var correctAnswersCount by remember { mutableIntStateOf(0) }
    var isQuizCompleted by remember { mutableStateOf(false) }

    // Tiles for Arrange/Sentence build
    val arrangedTiles = remember { mutableStateListOf<String>() }

    val currentQuestion = if (questions.isNotEmpty() && currentIndex < questions.size) questions[currentIndex] else null

    // Play listening audio automatically once per question
    LaunchedEffect(currentIndex) {
        selectedOption = null
        isSubmitted = false
        arrangedTiles.clear()
        if (currentQuestion?.type == QuestionType.LISTENING && currentQuestion.audioText != null) {
            viewModel.speak(currentQuestion.audioText)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { viewModel.navigateBack() },
                modifier = Modifier.testTag("quiz_runner_back")
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1f)
            )
            if (!isQuizCompleted && questions.isNotEmpty()) {
                Text(
                    text = "${currentIndex + 1} / ${questions.size}",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (!isQuizCompleted && questions.isNotEmpty()) {
            LinearProgressIndicator(
                progress = { ((currentIndex + 1).toFloat() / questions.size.toFloat()) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = KoreanBluePrimary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isQuizCompleted) {
            // Completion Summary Screen
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_completion_card")
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(KoreanGold)
                    ) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = "Success",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Practice Complete! 🎉",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Score: $correctAnswersCount out of ${questions.size}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = KoreanBluePrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    val percentage = if (questions.isNotEmpty()) (correctAnswersCount * 100) / questions.size else 0
                    Text(
                        text = if (percentage >= 80) "Daebak! Excellent work! (대박!)" else "Good practice! Keep reviewing!",
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            currentIndex = 0
                            correctAnswersCount = 0
                            isQuizCompleted = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Retry")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Practice Again", fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedButton(
                        onClick = { viewModel.navigateBack() },
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Return to Hub")
                    }
                }
            }
        } else if (currentQuestion != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Prompt Card
                item {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> currentQuestion.promptFil
                                    else -> currentQuestion.promptEn
                                },
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )

                            if (currentQuestion.promptKr != null) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = currentQuestion.promptKr,
                                        style = MaterialTheme.typography.headlineMedium.copy(
                                            fontWeight = FontWeight.ExtraBold,
                                            color = KoreanBluePrimary
                                        )
                                    )
                                    if (currentQuestion.audioText != null) {
                                        AudioSpeakerButton(
                                            onClick = { viewModel.speak(currentQuestion.audioText) },
                                            size = 40,
                                            iconSize = 22
                                        )
                                    }
                                }
                            } else if (currentQuestion.type == QuestionType.LISTENING && currentQuestion.audioText != null) {
                                Spacer(modifier = Modifier.height(12.dp))
                                Button(
                                    onClick = { viewModel.speak(currentQuestion.audioText) },
                                    colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                ) {
                                    Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Play sound")
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Replay Sound", fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                // If Word Arrange / Sentence Builder
                if (currentQuestion.type == QuestionType.WORD_ARRANGE || currentQuestion.type == QuestionType.SENTENCE_BUILD) {
                    item {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "Your Assembly:",
                                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    modifier = Modifier.fillMaxWidth().height(52.dp)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.CenterStart,
                                        modifier = Modifier.padding(horizontal = 12.dp)
                                    ) {
                                        val assembledText = arrangedTiles.joinToString(if (currentQuestion.type == QuestionType.SENTENCE_BUILD) " " else "")
                                        Text(
                                            text = assembledText.ifEmpty { "(Tap tiles below to assemble)" },
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = if (assembledText.isEmpty()) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) else KoreanBluePrimary
                                            )
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Available Tiles:",
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    val tiles = if (currentQuestion.arrangeTiles.isNotEmpty()) currentQuestion.arrangeTiles else currentQuestion.options
                                    tiles.forEach { tile ->
                                        val isUsed = arrangedTiles.contains(tile)
                                        Surface(
                                            shape = RoundedCornerShape(10.dp),
                                            color = if (isUsed) MaterialTheme.colorScheme.outline.copy(alpha = 0.2f) else KoreanBluePrimary,
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(10.dp))
                                                .clickable(enabled = !isUsed && !isSubmitted) {
                                                    arrangedTiles.add(tile)
                                                    selectedOption = arrangedTiles.joinToString(if (currentQuestion.type == QuestionType.SENTENCE_BUILD) " " else "")
                                                }
                                        ) {
                                            Text(
                                                text = tile,
                                                color = if (isUsed) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) else Color.White,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                            )
                                        }
                                    }

                                    if (arrangedTiles.isNotEmpty() && !isSubmitted) {
                                        Surface(
                                            shape = RoundedCornerShape(10.dp),
                                            color = KoreanRedAccent.copy(alpha = 0.2f),
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(10.dp))
                                                .clickable {
                                                    arrangedTiles.clear()
                                                    selectedOption = null
                                                }
                                        ) {
                                            Text(
                                                text = "Reset",
                                                color = KoreanRedAccent,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // Standard Options List (Multiple Choice, Translation, Listening, Hangul Recognition)
                    items(currentQuestion.options) { option ->
                        val isThisSelected = selectedOption == option
                        val isCorrect = selectedOption == currentQuestion.correctAnswer

                        val bgColor = when {
                            isSubmitted && option == currentQuestion.correctAnswer -> KoreanJade.copy(alpha = 0.2f)
                            isSubmitted && isThisSelected && !isCorrect -> KoreanRedAccent.copy(alpha = 0.2f)
                            isThisSelected -> KoreanBluePrimary.copy(alpha = 0.15f)
                            else -> MaterialTheme.colorScheme.surface
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = bgColor,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .clickable(enabled = !isSubmitted) {
                                    selectedOption = option
                                }
                                .testTag("quiz_option_$option")
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = option,
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        fontWeight = if (isThisSelected) FontWeight.Bold else FontWeight.Normal
                                    ),
                                    modifier = Modifier.weight(1f)
                                )
                                if (isSubmitted && option == currentQuestion.correctAnswer) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Correct",
                                        tint = KoreanJade
                                    )
                                } else if (isSubmitted && isThisSelected && !isCorrect) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Incorrect",
                                        tint = KoreanRedAccent
                                    )
                                }
                            }
                        }
                    }
                }

                // Check / Next Action Button
                item {
                    Spacer(modifier = Modifier.height(10.dp))

                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                if (selectedOption != null) {
                                    isSubmitted = true
                                    val correct = selectedOption == currentQuestion.correctAnswer
                                    if (correct) {
                                        correctAnswersCount++
                                    }
                                    viewModel.recordQuizResult(currentQuestion.id, correct)
                                }
                            },
                            enabled = selectedOption != null,
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("quiz_submit_button")
                        ) {
                            Text("Check Answer", fontWeight = FontWeight.Bold)
                        }
                    } else {
                        val isCorrect = selectedOption == currentQuestion.correctAnswer
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isCorrect) KoreanJade.copy(alpha = 0.15f) else KoreanRedAccent.copy(alpha = 0.15f)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = if (isCorrect) "Correct! 🎉" else "Not quite! 💡",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = if (isCorrect) KoreanJade else KoreanRedAccent
                                    )
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (language == LearningLanguage.FILIPINO) currentQuestion.explanationFil else currentQuestion.explanationEn,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                if (currentIndex + 1 < questions.size) {
                                    currentIndex++
                                } else {
                                    isQuizCompleted = true
                                }
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("quiz_next_button")
                        ) {
                            Text(
                                text = if (currentIndex + 1 < questions.size) "Next Question" else "See Results",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
