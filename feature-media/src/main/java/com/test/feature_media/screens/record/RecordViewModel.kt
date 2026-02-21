package com.test.feature_media.screens.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.common_ui.R
import com.test.core.base.MVI
import com.test.core.base.mvi
import com.test.domain.base.AppResources

class RecordViewModel(
    private val appResources: AppResources
) : ViewModel(),
    MVI<RecordContract.UiState, RecordContract.UiAction, RecordContract.SideEffect> by mvi(
        initialUiState()
    ) {
    override fun onAction(uiAction: RecordContract.UiAction) {
        when (uiAction) {
            is RecordContract.UiAction.OnCameraResult -> viewModelScope.emitSideEffect(
                RecordContract.SideEffect.ShowToast(
                    if (uiAction.isSuccess)
                        appResources.getString(R.string.video_saved_successfully)
                    else appResources.getString(R.string.video_capture_failed)
                )
            )
        }
    }
}

private fun initialUiState() =
    RecordContract.UiState(
        isLoading = false
    )