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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
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
import com.example.model.Lesson
import com.example.model.LessonSection
import com.example.ui.MainViewModel
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

@Composable
fun LessonViewerScreen(
    lesson: Lesson,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val language by viewModel.selectedLanguage.collectAsState()
    val completedLessons by viewModel.completedLessonIds.collectAsState()
    val isAlreadyCompleted = completedLessons.contains(lesson.id)

    // Store selected quiz answers & submit states
    val selectedAnswers = remember { mutableStateMapOf<String, String>() }
    val submittedQuestions = remember { mutableStateMapOf<String, Boolean>() }
    var lessonFinishedBanner by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Navigation Header
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { viewModel.navigateBack() },
                    modifier = Modifier.testTag("lesson_viewer_back")
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Lesson ${lesson.number}",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = KoreanBluePrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = when (language) {
                            LearningLanguage.FILIPINO -> lesson.titleFil
                            LearningLanguage.KOREAN -> lesson.titleKo
                            else -> lesson.titleEn
                        },
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }

        // Render Lesson Sections
        items(lesson.sections) { section ->
            when (section) {
                is LessonSection.Introduction -> {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> section.headingFil
                                    else -> section.headingEn
                                },
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreanBluePrimary
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> section.contentFil
                                    else -> section.contentEn
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                lineHeight = 22.sp
                            )
                        }
                    }
                }

                is LessonSection.Dialogue -> {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.RecordVoiceOver,
                                    contentDescription = "Dialogue",
                                    tint = KoreanBluePrimary
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = when (language) {
                                        LearningLanguage.FILIPINO -> section.titleFil
                                        else -> section.titleEn
                                    },
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            section.lines.forEach { line ->
                                Surface(
                                    shape = RoundedCornerShape(14.dp),
                                    color = MaterialTheme.colorScheme.surface,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "${line.speaker}: ${line.korean}",
                                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                                            )
                                            Text(
                                                text = line.romanization,
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            )
                                            Text(
                                                text = when (language) {
                                                    LearningLanguage.FILIPINO -> line.filipino
                                                    else -> line.english
                                                },
                                                style = MaterialTheme.typography.bodyMedium.copy(
                                                    color = KoreanBluePrimary,
                                                    fontWeight = FontWeight.Medium
                                                )
                                            )
                                        }

                                        AudioSpeakerButton(
                                            onClick = { viewModel.speak(line.korean) },
                                            size = 36,
                                            iconSize = 18
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                is LessonSection.GrammarPoint -> {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = KoreanJade.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "Grammar: ${if (language == LearningLanguage.FILIPINO) section.titleFil else section.titleEn}",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        color = KoreanJade,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Pattern: ${section.pattern}",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = KoreanBluePrimary
                                    ),
                                    modifier = Modifier.padding(10.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> section.explanationFil
                                    else -> section.explanationEn
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                lineHeight = 20.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Examples:",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                            )

                            section.examples.forEach { eg ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = eg.korean,
                                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                                        )
                                        Text(
                                            text = "(${eg.romanization}) - ${if (language == LearningLanguage.FILIPINO) eg.filipino else eg.english}",
                                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        )
                                    }
                                    AudioSpeakerButton(
                                        onClick = { viewModel.speak(eg.korean) },
                                        size = 32,
                                        iconSize = 16
                                    )
                                }
                            }
                        }
                    }
                }

                is LessonSection.CultureTip -> {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = "Culture",
                                    tint = KoreanRedAccent
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "🇰🇷 Cultural Tip: ${if (language == LearningLanguage.FILIPINO) section.titleFil else section.titleEn}",
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = KoreanRedAccent
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> section.textFil
                                    else -> section.textEn
                                },
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                else -> {}
            }
        }

        // Interactive Lesson Mini-Quiz Section
        if (lesson.quiz.isNotEmpty()) {
            item {
                Text(
                    text = "📝 Lesson Quick Check",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            items(lesson.quiz) { question ->
                val selected = selectedAnswers[question.id]
                val isSubmitted = submittedQuestions[question.id] == true
                val isCorrect = selected == question.correctAnswer

                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.FILIPINO -> question.promptFil
                                    else -> question.promptEn
                                },
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.weight(1f)
                            )
                            if (question.audioText != null) {
                                AudioSpeakerButton(
                                    onClick = { viewModel.speak(question.audioText) },
                                    size = 32,
                                    iconSize = 16
                                )
                            }
                        }

                        if (question.promptKr != null) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = question.promptKr,
                                style = MaterialTheme.typography.headlineSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreanBluePrimary
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        question.options.forEach { option ->
                            val isThisSelected = selected == option
                            val backgroundColor = when {
                                isSubmitted && option == question.correctAnswer -> KoreanJade.copy(alpha = 0.2f)
                                isSubmitted && isThisSelected && !isCorrect -> KoreanRedAccent.copy(alpha = 0.2f)
                                isThisSelected -> KoreanBluePrimary.copy(alpha = 0.15f)
                                else -> MaterialTheme.colorScheme.surface
                            }
                            val borderColor = when {
                                isSubmitted && option == question.correctAnswer -> KoreanJade
                                isSubmitted && isThisSelected && !isCorrect -> KoreanRedAccent
                                isThisSelected -> KoreanBluePrimary
                                else -> Color.Transparent
                            }

                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = backgroundColor,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable(enabled = !isSubmitted) {
                                        selectedAnswers[question.id] = option
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = option,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontWeight = if (isThisSelected) FontWeight.Bold else FontWeight.Normal
                                        ),
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (isSubmitted && option == question.correctAnswer) {
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

                        Spacer(modifier = Modifier.height(8.dp))

                        if (!isSubmitted) {
                            Button(
                                onClick = {
                                    if (selected != null) {
                                        submittedQuestions[question.id] = true
                                        viewModel.recordQuizResult(question.id, isCorrect)
                                    }
                                },
                                enabled = selected != null,
                                modifier = Modifier.align(Alignment.End),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Check Answer")
                            }
                        } else {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isCorrect) KoreanJade.copy(alpha = 0.15f) else KoreanRedAccent.copy(alpha = 0.15f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = if (language == LearningLanguage.FILIPINO) question.explanationFil else question.explanationEn,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = if (isCorrect) KoreanJade else KoreanRedAccent,
                                        fontWeight = FontWeight.Medium
                                    ),
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Completion Action Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isAlreadyCompleted || lessonFinishedBanner) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Completed",
                                tint = KoreanJade,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Lesson Completed! 🎉",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreanJade
                                )
                            )
                        }
                    } else {
                        Text(
                            text = "Ready to complete this lesson?",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                viewModel.completeLesson(lesson.id)
                                lessonFinishedBanner = true
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("mark_lesson_completed_button")
                        ) {
                            Text("Mark Lesson as Completed", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
