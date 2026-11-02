package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.ui.MainViewModel
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

@Composable
fun HangulSyllableBuilderScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val language by viewModel.selectedLanguage.collectAsState()

    // 19 Initials (초성)
    val initials = listOf(
        "ㄱ" to "g", "ㄴ" to "n", "ㄷ" to "d", "ㄹ" to "r", "ㅁ" to "m",
        "ㅂ" to "b", "ㅅ" to "s", "ㅇ" to "", "ㅈ" to "j", "ㅊ" to "ch",
        "ㅋ" to "k", "ㅌ" to "t", "ㅍ" to "p", "ㅎ" to "h"
    )

    // 21 Vowels (중성)
    val vowels = listOf(
        "ㅏ" to "a", "ㅑ" to "ya", "ㅓ" to "eo", "ㅕ" to "yeo", "ㅗ" to "o",
        "ㅛ" to "yo", "ㅜ" to "u", "ㅠ" to "yu", "ㅡ" to "eu", "ㅣ" to "i",
        "ㅐ" to "ae", "ㅔ" to "e"
    )

    // 28 Finals / Batchim (종성) - 0 is none
    val batchims = listOf(
        "" to "None", "ㄱ" to "k", "ㄴ" to "n", "ㄷ" to "t", "ㄹ" to "l",
        "ㅁ" to "m", "ㅂ" to "p", "ㅇ" to "ng", "ㅅ" to "t", "ㅈ" to "t", "ㅎ" to "t"
    )

    var selectedInitialIndex by remember { mutableIntStateOf(0) } // ㄱ
    var selectedVowelIndex by remember { mutableIntStateOf(0) }   // ㅏ
    var selectedBatchimIndex by remember { mutableIntStateOf(0) } // None

    // Korean Unicode Formula:
    // Syllable = 0xAC00 + (initialIndex * 21 + vowelIndex) * 28 + batchimIndex
    // Map initial index:
    val initialKoreanIndices = listOf(0, 2, 3, 5, 6, 7, 9, 11, 12, 14, 15, 16, 17, 18)
    val vowelKoreanIndices = listOf(0, 2, 4, 6, 8, 12, 13, 17, 18, 20, 1, 5)
    val batchimKoreanIndices = listOf(0, 1, 4, 7, 8, 16, 17, 21, 19, 22, 27)

    val actualInit = initialKoreanIndices[selectedInitialIndex.coerceIn(0, initialKoreanIndices.size - 1)]
    val actualVowel = vowelKoreanIndices[selectedVowelIndex.coerceIn(0, vowelKoreanIndices.size - 1)]
    val actualBatchim = batchimKoreanIndices[selectedBatchimIndex.coerceIn(0, batchimKoreanIndices.size - 1)]

    val unicodeChar = (0xAC00 + (actualInit * 21 + actualVowel) * 28 + actualBatchim).toChar().toString()

    val initRoman = initials[selectedInitialIndex].second
    val vowelRoman = vowels[selectedVowelIndex].second
    val batchimRoman = if (selectedBatchimIndex == 0) "" else batchims[selectedBatchimIndex].second
    val fullRomanization = "$initRoman$vowelRoman$batchimRoman"

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { viewModel.navigateBack() },
                    modifier = Modifier.testTag("builder_back_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = when (language) {
                        LearningLanguage.FILIPINO -> "Pagsasama ng Pantig (Hangul Builder)"
                        LearningLanguage.KOREAN -> "한글 음절 조합기"
                        else -> "Hangul Syllable Builder"
                    },
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }

        // Output Result Syllable Box
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("combined_syllable_display")
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${initials[selectedInitialIndex].first} + ${vowels[selectedVowelIndex].first}${if (selectedBatchimIndex > 0) " + " + batchims[selectedBatchimIndex].first else ""} =",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = unicodeChar,
                        style = MaterialTheme.typography.displayLarge.copy(
                            fontWeight = FontWeight.ExtraBold,
                            color = KoreanBluePrimary,
                            fontSize = 72.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "[$fullRomanization]",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = { viewModel.speak(unicodeChar) },
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Play")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Hear Pronunciation", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Preset Examples from Syllabus:
        item {
            Text(
                text = "Preset Syllabus Examples (Tap to load):",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf(
                    Triple("가 (ga)", 0, 0 to 0), // ㄱ + ㅏ
                    Triple("나 (na)", 1, 0 to 0), // ㄴ + ㅏ
                    Triple("무 (mu)", 4, 6 to 0), // ㅁ + ㅜ
                    Triple("한 (han)", 13, 0 to 2), // ㅎ + ㅏ + ㄴ
                    Triple("학 (hak)", 13, 0 to 1)  // ㅎ + ㅏ + ㄱ
                ).forEach { (label, initIdx, rest) ->
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                                selectedInitialIndex = initIdx
                                selectedVowelIndex = rest.first
                                selectedBatchimIndex = rest.second
                            }
                    ) {
                        Text(
                            text = label,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }

        // Section 1: Select Initial Consonant (초성)
        item {
            Text(
                text = "1. Select Initial Consonant (초성)",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(initials.indices.toList()) { idx ->
                    val item = initials[idx]
                    val isSelected = selectedInitialIndex == idx
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) KoreanBluePrimary else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { selectedInitialIndex = idx }
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = item.first,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                            Text(
                                text = item.second.ifEmpty { "silent" },
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = if (isSelected) Color.White.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                                )
                            )
                        }
                    }
                }
            }
        }

        // Section 2: Select Vowel (중성)
        item {
            Text(
                text = "2. Select Vowel (중성)",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(vowels.indices.toList()) { idx ->
                    val item = vowels[idx]
                    val isSelected = selectedVowelIndex == idx
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) KoreanJade else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { selectedVowelIndex = idx }
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = item.first,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                            Text(
                                text = item.second,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = if (isSelected) Color.White.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                                )
                            )
                        }
                    }
                }
            }
        }

        // Section 3: Select Optional Batchim / Final Consonant (종성)
        item {
            Text(
                text = "3. Select Final Consonant / Batchim (종성 / 받침)",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(batchims.indices.toList()) { idx ->
                    val item = batchims[idx]
                    val isSelected = selectedBatchimIndex == idx
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) KoreanRedAccent else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { selectedBatchimIndex = idx }
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = item.first.ifEmpty { "None" },
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                            Text(
                                text = item.second,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = if (isSelected) Color.White.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                                )
                            )
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
