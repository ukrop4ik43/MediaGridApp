package com.test.mediagridapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.test.feature_media.navigation.MediaNavigation
import com.test.mediagridapp.ui.navigation.model.NavModule

@Composable
fun NavHost() {
    val backStack = remember { mutableStateListOf<NavModule>(NavModule.MediaModule) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<NavModule.MediaModule> {
                MediaNavigation()
            }
        }
    )
}