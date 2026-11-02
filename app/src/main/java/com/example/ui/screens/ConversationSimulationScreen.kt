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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.data.PracticeData
import com.example.model.ConversationChoice
import com.example.model.LearningLanguage
import com.example.ui.MainViewModel
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

@Composable
fun ConversationSimulationScreen(
    conversationId: String,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val language by viewModel.selectedLanguage.collectAsState()
    val conv = PracticeData.conversations.firstOrNull { it.id == conversationId } ?: PracticeData.conversations.first()

    var currentStepIndex by remember { mutableIntStateOf(0) }
    var selectedChoice by remember { mutableStateOf<ConversationChoice?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }
    var isSimulationFinished by remember { mutableStateOf(false) }

    val currentStep = if (currentStepIndex < conv.steps.size) conv.steps[currentStepIndex] else null

    LaunchedEffect(currentStepIndex) {
        selectedChoice = null
        isSubmitted = false
        if (currentStep != null) {
            viewModel.speak(currentStep.koreanPrompt)
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Header
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { viewModel.navigateBack() },
                    modifier = Modifier.testTag("conv_back_button")
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = when (language) {
                            LearningLanguage.FILIPINO -> conv.titleFil
                            else -> conv.titleEn
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = KoreanRedAccent,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = conv.location,
                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                        )
                    }
                }
            }
        }

        // Scenario Card
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "🎭 Situation:",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = when (language) {
                            LearningLanguage.FILIPINO -> conv.scenarioFil
                            else -> conv.scenarioEn
                        },
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        if (isSimulationFinished) {
            item {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Dialogue Completed! 🎉",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = KoreanBluePrimary
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "You successfully navigated a real-life situation in Korea!",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                currentStepIndex = 0
                                isSimulationFinished = false
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary)
                        ) {
                            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Replay")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Replay Dialogue", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        } else if (currentStep != null) {
            // Character Dialogue Prompt Bubble
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(18.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(KoreanJade)
                        ) {
                            Text(
                                text = currentStep.speaker.take(1),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = currentStep.speaker,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = KoreanJade
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = currentStep.koreanPrompt,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            )
                            Text(
                                text = currentStep.romanization,
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Meaning: ${if (language == LearningLanguage.FILIPINO) currentStep.meaningFil else currentStep.meaningEn}",
                                style = MaterialTheme.typography.bodyMedium.copy(color = KoreanBluePrimary)
                            )
                        }

                        AudioSpeakerButton(
                            onClick = { viewModel.speak(currentStep.koreanPrompt) },
                            size = 38,
                            iconSize = 20
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Select your response:",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                )
            }

            // Selectable Response Choices
            items(currentStep.choices) { choice ->
                val isThisSelected = selectedChoice == choice
                val bgColor = when {
                    isSubmitted && choice.isBest -> KoreanJade.copy(alpha = 0.2f)
                    isSubmitted && isThisSelected && !choice.isBest -> KoreanRedAccent.copy(alpha = 0.2f)
                    isThisSelected -> KoreanBluePrimary.copy(alpha = 0.15f)
                    else -> MaterialTheme.colorScheme.surface
                }

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = bgColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(enabled = !isSubmitted) {
                            selectedChoice = choice
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = choice.korean,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = if (isThisSelected) KoreanBluePrimary else MaterialTheme.colorScheme.onSurface
                                    )
                                )
                                Text(
                                    text = choice.romanization,
                                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                                )
                                Text(
                                    text = if (language == LearningLanguage.FILIPINO) choice.meaningFil else choice.meaningEn,
                                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                                )
                            }

                            if (isSubmitted && choice.isBest) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Best Choice",
                                    tint = KoreanJade
                                )
                            } else if (isSubmitted && isThisSelected && !choice.isBest) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Not best",
                                    tint = KoreanRedAccent
                                )
                            }
                        }

                        if (isSubmitted && (choice.isBest || isThisSelected)) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "💡 ${if (language == LearningLanguage.FILIPINO) choice.explanationFil else choice.explanationEn}",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = if (choice.isBest) KoreanJade else KoreanRedAccent
                                )
                            )
                        }
                    }
                }
            }

            // Submit / Next Step Button
            item {
                Spacer(modifier = Modifier.height(10.dp))
                if (!isSubmitted) {
                    Button(
                        onClick = {
                            if (selectedChoice != null) {
                                isSubmitted = true
                            }
                        },
                        enabled = selectedChoice != null,
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Confirm Response", fontWeight = FontWeight.Bold)
                    }
                } else {
                    Button(
                        onClick = {
                            if (currentStepIndex + 1 < conv.steps.size) {
                                currentStepIndex++
                            } else {
                                isSimulationFinished = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = if (currentStepIndex + 1 < conv.steps.size) "Continue Conversation" else "Finish Conversation",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
