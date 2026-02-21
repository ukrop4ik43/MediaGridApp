package com.test.feature_media.screens.list

import com.test.domain.media.model.Video

interface ListContract {
    data class UiState(
        val isLoading: Boolean = false, val listOfVideo: List<Video> = emptyList()
    )

    sealed interface UiAction {
        object OnVideoClick : UiAction
        object Init : UiAction
        object OnRecordClick : UiAction
    }

    sealed interface SideEffect
}