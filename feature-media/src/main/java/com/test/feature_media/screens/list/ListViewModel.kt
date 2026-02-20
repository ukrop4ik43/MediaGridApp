package com.test.feature_media.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.core.base.MVI
import com.test.core.base.mvi


class ListViewModel constructor(
) : ViewModel(),
    MVI<ListContract.UiState, ListContract.UiAction, ListContract.SideEffect> by mvi(
        initialUiState()
    ) {
    override fun onAction(uiAction: ListContract.UiAction) {
        when (uiAction) {
            ListContract.UiAction.OnRecordClick -> viewModelScope.emitSideEffect(
                StartContract.SideEffect.GoToChooseYourCar
            )
        }
    }
}

private fun initialUiState() =
    ListContract.UiState(
        isLoading = false
    )