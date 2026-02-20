package com.test.mediagridapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.test.mediagridapp.ui.navigation.model.ScreenEntry

@Composable
fun NavHost() {
    val backStack = remember { mutableStateListOf<ScreenEntry>(ScreenEntry.HomeScreen) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<ScreenEntry.HomeScreen> {
                CarNavComponent({ backStack.add(TopLevelEntry.Ai) })
            }
        }
    )
}