package com.test.feature_media.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.core.base.MVI
import com.test.core.base.mvi
import com.test.domain.media.repository.MediaRepository
import kotlinx.coroutines.launch


class ListViewModel(
    private val mediaRepository: MediaRepository
) : ViewModel(),
    MVI<ListContract.UiState, ListContract.UiAction, ListContract.SideEffect> by mvi(
        initialUiState()
    ) {
    override fun onAction(uiAction: ListContract.UiAction) {
        when (uiAction) {
//            ListContract.UiAction.OnRecordClick -> viewModelScope.emitSideEffect(
//                StartContract.SideEffect.GoToChooseYourCar
//            )
            ListContract.UiAction.Init -> {
                viewModelScope.launch {
                    val videoList = mediaRepository.getAllVideos()
                    updateUiState { copy(listOfVideo = videoList) }
                }
            }

            ListContract.UiAction.OnRecordClick -> {}
            ListContract.UiAction.OnVideoClick -> {}
        }
    }
}

private fun initialUiState() =
    ListContract.UiState(
        isLoading = false
    )