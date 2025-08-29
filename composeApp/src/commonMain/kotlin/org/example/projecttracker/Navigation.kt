package org.example.projecttracker

import androidx.compose.runtime.*

sealed class Screen {
    object Main : Screen()
    object GlassMorphism : Screen()
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }
    
    when (currentScreen) {
        Screen.Main -> {
            App(
                onNavigateToGlassMorphism = {
                    currentScreen = Screen.GlassMorphism
                }
            )
        }
        Screen.GlassMorphism -> {
            GlassMorphismScreen(
                onBackPressed = {
                    currentScreen = Screen.Main
                }
            )
        }
    }
}
