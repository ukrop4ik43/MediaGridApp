package com.test.feature_media.screens.list

interface ListContract {
    data class UiState(
        val isLoading: Boolean = false, val listOfMediaRoutes: List<String> = emptyList()
    )

    sealed interface UiAction {
        object OnVideoClick : UiAction
        object OnRecordClick : UiAction
    }

    sealed interface SideEffect
}