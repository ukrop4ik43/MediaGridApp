package com.test.feature_media.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.test.core.navigation.routes.MediaRoute

@Composable
fun MediaNavigation(onAiSectionClick: () -> Unit) {
    val backStack = remember { mutableStateListOf<MediaRoute>(MediaRoute.ListScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<MediaRoute.ListScreen> {

            }
        })
}