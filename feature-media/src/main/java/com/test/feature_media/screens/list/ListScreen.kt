package com.test.feature_media.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ListScreen(
    uiState: ListContract.UiState,
    onAction: (ListContract.UiAction) -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        Text(
            "Record new video", modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    onAction(ListContract.UiAction.OnRecordClick)
                }
        )
    }
}