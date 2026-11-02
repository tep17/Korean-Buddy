package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = KoreanBluePrimaryDark,
    onPrimary = Color(0xFF0F172A),
    primaryContainer = KoreanBlueContainerDark,
    onPrimaryContainer = KoreanOnBlueContainerDark,
    secondary = KoreanRedAccentDark,
    onSecondary = Color(0xFF450A0A),
    secondaryContainer = KoreanRedContainerDark,
    onSecondaryContainer = KoreanOnRedContainerDark,
    tertiary = KoreanJadeDark,
    onTertiary = Color(0xFF042F2E),
    tertiaryContainer = KoreanJadeContainerDark,
    background = KoreanBackgroundDark,
    onBackground = KoreanTextPrimaryDark,
    surface = KoreanSurfaceDark,
    onSurface = KoreanTextPrimaryDark,
    surfaceVariant = KoreanCardDark,
    onSurfaceVariant = KoreanTextSecondaryDark,
    outline = Color(0xFF334155)
)

private val LightColorScheme = lightColorScheme(
    primary = KoreanBluePrimary,
    onPrimary = Color.White,
    primaryContainer = KoreanBlueContainer,
    onPrimaryContainer = KoreanOnBlueContainer,
    secondary = KoreanRedAccent,
    onSecondary = Color.White,
    secondaryContainer = KoreanRedContainer,
    onSecondaryContainer = KoreanOnRedContainer,
    tertiary = KoreanJade,
    onTertiary = Color.White,
    tertiaryContainer = KoreanJadeContainer,
    onTertiaryContainer = KoreanOnJadeContainer,
    background = KoreanBackgroundLight,
    onBackground = KoreanTextPrimaryLight,
    surface = KoreanSurfaceLight,
    onSurface = KoreanTextPrimaryLight,
    surfaceVariant = KoreanCardLight,
    onSurfaceVariant = KoreanTextSecondaryLight,
    outline = Color(0xFFCBD5E1)
)

@Composable
fun KoreanBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
