package com.test.core.navigation.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface MediaRoute : NavKey {
    @Serializable
    data object ListScreen : MediaRoute
}
