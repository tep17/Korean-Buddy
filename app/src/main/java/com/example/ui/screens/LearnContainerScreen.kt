package com.example.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.model.LearningLanguage
import com.example.ui.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnContainerScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val language by viewModel.selectedLanguage.collectAsState()
    var subTab by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        PrimaryTabRow(
            selectedTabIndex = subTab,
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = subTab == 0,
                onClick = { subTab = 0 },
                text = {
                    Text(
                        text = when (language) {
                            LearningLanguage.FILIPINO -> "🔤 Alpabetong Hangul"
                            LearningLanguage.KOREAN -> "🔤 한글 알파벳"
                            else -> "🔤 Hangul Alphabet"
                        },
                        fontWeight = if (subTab == 0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )

            Tab(
                selected = subTab == 1,
                onClick = { subTab = 1 },
                text = {
                    Text(
                        text = when (language) {
                            LearningLanguage.FILIPINO -> "📚 Mga Antas ng Aralin"
                            LearningLanguage.KOREAN -> "📚 정규 강의 코스"
                            else -> "📚 Structured Courses"
                        },
                        fontWeight = if (subTab == 1) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }

        if (subTab == 0) {
            HangulScreen(viewModel = viewModel)
        } else {
            LearnScreen(viewModel = viewModel)
        }
    }
}
