package com.test.mediagridapp.ui.navigation.model

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavModule : NavKey {
    @Serializable
    data object MediaModule : NavModule
}

