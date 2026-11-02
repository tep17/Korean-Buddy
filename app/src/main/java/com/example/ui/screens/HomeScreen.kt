package com.example.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Spellcheck
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.CourseData
import com.example.data.VocabularyData
import com.example.model.LearningLanguage
import com.example.model.QuestionType
import com.example.ui.AppDestination
import com.example.ui.MainViewModel
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGold
import com.example.ui.theme.KoreanJade
import com.example.ui.theme.KoreanRedAccent

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.selectedLanguage.collectAsState()
    val streakDays by viewModel.streakDays.collectAsState()
    val dailyGoal by viewModel.dailyGoal.collectAsState()
    val todayCompleted by viewModel.todayCompletedLessons.collectAsState()
    val completedLessons by viewModel.completedLessonIds.collectAsState()
    val totalMinutes by viewModel.totalStudyMinutes.collectAsState()
    val srsMap by viewModel.srsLevels.collectAsState()

    val dailyWord = VocabularyData.dailyWord
    val dailyPhrase = VocabularyData.dailyPhrase
    val totalLessonsCount = CourseData.allLessons.size
    val courseProgressPercent = if (totalLessonsCount > 0) (completedLessons.size.toFloat() / totalLessonsCount.toFloat()) else 0f
    val masteredWordsCount = srsMap.count { it.value >= 1 }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Banner Card with Seoul Skyline illustration
        item {
            Spacer(modifier = Modifier.height(4.dp))
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("hero_banner_card"),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth().height(160.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.hero_korean),
                        contentDescription = "Seoul skyline and Hanok",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    // Gradient overlay
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color(0xCC0F172A)
                                    )
                                )
                            )
                    )
                    // Mascot greeting and subtitle
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = KoreanRedAccent
                        ) {
                            Text(
                                text = "🇰🇷 Korean Buddy",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = when (language) {
                                LearningLanguage.ENGLISH -> "Annyeonghaseyo! Ready to learn Korean?"
                                LearningLanguage.FILIPINO -> "Kumusta! Handa ka na bang mag-aral ng Korean?"
                                LearningLanguage.KOREAN -> "안녕하세요! 오늘 함께 한국어를 배워봐요!"
                            },
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }

        // Daily Goal & Streak Row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Streak Card
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(KoreanGold.copy(alpha = 0.2f))
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = "Streak",
                                tint = KoreanGold,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "$streakDays Days",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = when (language) {
                                    LearningLanguage.ENGLISH -> "Daily Streak"
                                    LearningLanguage.FILIPINO -> "Arawang Streak"
                                    LearningLanguage.KOREAN -> "연속 학습"
                                },
                                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                        }
                    }
                }

                // Daily Goal Card
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.ENGLISH -> "Daily Goal"
                                    LearningLanguage.FILIPINO -> "Arawang Layunin"
                                    LearningLanguage.KOREAN -> "일일 목표"
                                },
                                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                            Text(
                                text = "$todayCompleted / $dailyGoal",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { (todayCompleted.toFloat() / dailyGoal.toFloat()).coerceIn(0f, 1f) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = KoreanJade,
                            trackColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                        )
                    }
                }
            }
        }

        // Daily Korean Word Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("daily_word_card")
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.ENGLISH -> "✨ Daily Korean Word"
                                    LearningLanguage.FILIPINO -> "✨ Arawang Salitang Korean"
                                    LearningLanguage.KOREAN -> "✨ 오늘의 한국어 단어"
                                },
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        AudioSpeakerButton(
                            onClick = { viewModel.speak(dailyWord.korean) },
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = dailyWord.korean,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "(${dailyWord.romanization})",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = when (language) {
                            LearningLanguage.ENGLISH -> "English: ${dailyWord.english}"
                            LearningLanguage.FILIPINO -> "Tagalog: ${dailyWord.filipino}"
                            LearningLanguage.KOREAN -> "한국어 의미: ${dailyWord.english}"
                        },
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )

                    if (language != LearningLanguage.FILIPINO) {
                        Text(
                            text = "Filipino: ${dailyWord.filipino}",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = dailyWord.exampleKr,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                                )
                                Text(
                                    text = when (language) {
                                        LearningLanguage.FILIPINO -> dailyWord.exampleFil
                                        else -> dailyWord.exampleEn
                                    },
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                )
                            }
                            AudioSpeakerButton(
                                onClick = { viewModel.speak(dailyWord.exampleKr) },
                                size = 32,
                                iconSize = 16
                            )
                        }
                    }
                }
            }
        }

        // Daily Korean Phrase Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("daily_phrase_card")
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = KoreanRedAccent
                        ) {
                            Text(
                                text = when (language) {
                                    LearningLanguage.ENGLISH -> "💬 Korean Phrase of the Day"
                                    LearningLanguage.FILIPINO -> "💬 Parirala ng Araw"
                                    LearningLanguage.KOREAN -> "💬 오늘의 회화 표현"
                                },
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        AudioSpeakerButton(
                            onClick = { viewModel.speak(dailyPhrase.korean) },
                            containerColor = KoreanRedAccent,
                            contentColor = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = dailyPhrase.korean,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    )
                    Text(
                        text = "${dailyPhrase.romanization} • Guide: \"${dailyPhrase.pronunciationTip}\"",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "🇺🇸 English: ${dailyPhrase.english}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    )
                    Text(
                        text = "🇵🇭 Filipino: ${dailyPhrase.filipino}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
        }

        // Action Buttons Row: Continue Learning & Start Practice
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        val nextLesson = CourseData.allLessons.firstOrNull { !completedLessons.contains(it.id) }
                            ?: CourseData.allLessons.first()
                        viewModel.navigateTo(AppDestination.LessonView(nextLesson))
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .testTag("continue_learning_button"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Continue",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = when (language) {
                            LearningLanguage.ENGLISH -> "Continue"
                            LearningLanguage.FILIPINO -> "Magpatuloy"
                            LearningLanguage.KOREAN -> "학습 계속하기"
                        },
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = { viewModel.setTab(2) }, // Switch to Practice Tab
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .testTag("start_practice_button"),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FitnessCenter,
                        contentDescription = "Practice",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = when (language) {
                            LearningLanguage.ENGLISH -> "Start Practice"
                            LearningLanguage.FILIPINO -> "Magsanay"
                            LearningLanguage.KOREAN -> "연습하기"
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Hangul Alphabet Shortcut Banner
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.navigateTo(AppDestination.HangulSyllableBuilder) }
                    .testTag("hangul_shortcut_card")
            ) {
                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(KoreanBluePrimary)
                    ) {
                        Text(
                            text = "한글",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = when (language) {
                                LearningLanguage.ENGLISH -> "Hangul Alphabet Studio"
                                LearningLanguage.FILIPINO -> "Alpabetong Hangul Studio"
                                LearningLanguage.KOREAN -> "한글 알파벳 스튜디오"
                            },
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = when (language) {
                                LearningLanguage.ENGLISH -> "Consonants, Vowels & Syllable Builder"
                                LearningLanguage.FILIPINO -> "Mga Katinig, Patinig at Pagsasama ng Pantig"
                                LearningLanguage.KOREAN -> "자음, 모음 및 음절 블록 조합"
                            },
                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Open Hangul",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Learning Statistics Overview Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = when (language) {
                            LearningLanguage.ENGLISH -> "📊 Overall Course Progress"
                            LearningLanguage.FILIPINO -> "📊 Pangkalahatang Progreso"
                            LearningLanguage.KOREAN -> "📊 전체 학습 진도"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LinearProgressIndicator(
                        progress = { courseProgressPercent.coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = KoreanBluePrimary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        StatItem(
                            number = "${completedLessons.size} / $totalLessonsCount",
                            label = when (language) {
                                LearningLanguage.ENGLISH -> "Lessons Done"
                                LearningLanguage.FILIPINO -> "Tapos na Aralin"
                                LearningLanguage.KOREAN -> "완료한 강의"
                            }
                        )
                        StatItem(
                            number = "$masteredWordsCount",
                            label = when (language) {
                                LearningLanguage.ENGLISH -> "Words Mastered"
                                LearningLanguage.FILIPINO -> "Kabisadong Salita"
                                LearningLanguage.KOREAN -> "익힌 단어"
                            }
                        )
                        StatItem(
                            number = "$totalMinutes m",
                            label = when (language) {
                                LearningLanguage.ENGLISH -> "Study Time"
                                LearningLanguage.FILIPINO -> "Oras ng Pag-aaral"
                                LearningLanguage.KOREAN -> "학습 시간"
                            }
                        )
                    }
                }
            }
        }

        // Recently Completed Lessons
        if (completedLessons.isNotEmpty()) {
            item {
                Column {
                    Text(
                        text = when (language) {
                            LearningLanguage.ENGLISH -> "Recently Completed"
                            LearningLanguage.FILIPINO -> "Kamakailang Natapos"
                            LearningLanguage.KOREAN -> "최근 완료한 학습"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    CourseData.allLessons
                        .filter { completedLessons.contains(it.id) }
                        .take(2)
                        .forEach { lesson ->
                            Card(
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable { viewModel.navigateTo(AppDestination.LessonView(lesson)) }
                            ) {
                                Row(
                                    modifier = Modifier.padding(14.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Completed",
                                        tint = KoreanJade,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = when (language) {
                                                LearningLanguage.FILIPINO -> lesson.titleFil
                                                LearningLanguage.KOREAN -> lesson.titleKo
                                                else -> lesson.titleEn
                                            },
                                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                                        )
                                        Text(
                                            text = lesson.levelId.subtitle,
                                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        )
                                    }
                                }
                            }
                        }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun StatItem(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = number,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
    }
}
