package com.test.mediagridapp.ui.navigation.model

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenEntry : NavKey {
    @Serializable
    data object HomeScreen : ScreenEntry
}

