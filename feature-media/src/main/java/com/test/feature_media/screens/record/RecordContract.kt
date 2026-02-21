package com.test.feature_media.screens.record

interface RecordContract {
    data class UiState(
        val isLoading: Boolean = false
    )

    sealed interface UiAction {
        class OnCameraResult(val isSuccess:Boolean): UiAction
    }

    sealed interface SideEffect {
        class ShowToast(val title: String) : SideEffect
    }
}