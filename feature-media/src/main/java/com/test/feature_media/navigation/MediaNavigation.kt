package com.test.feature_media.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.test.core.base.CollectSideEffect
import com.test.core.navigation.routes.MediaRoute
import com.test.feature_media.screens.record.RecordContract
import com.test.feature_media.screens.record.RecordScreen
import com.test.feature_media.screens.record.RecordViewModel
import com.test.feature_media.util.CAMERAX_PERMISSIONS
import com.test.common_ui.util.findActivity
import com.test.feature_media.screens.list.ListContract
import com.test.feature_media.screens.list.ListScreen
import com.test.feature_media.screens.list.ListViewModel
import com.test.feature_media.util.hasRequiredPermissions
import org.koin.androidx.compose.koinViewModel

@Composable
fun MediaNavigation() {
    val backStack = remember { mutableStateListOf<MediaRoute>(MediaRoute.ListScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<MediaRoute.ListScreen> {
                val context = LocalContext.current
                val vm: ListViewModel = koinViewModel()
                val uiState by vm.uiState.collectAsState()
                LaunchedEffect(Unit) {
                    if (!context.hasRequiredPermissions()) {
                        ActivityCompat.requestPermissions(
                            context.findActivity(), CAMERAX_PERMISSIONS, 0
                        )
                    }
                    vm.onAction(ListContract.UiAction.Init)
                }


                ListScreen(
                    uiState = uiState, onAction =
                        { action ->
                            vm.onAction(action)
                            when (action) {
                                ListContract.UiAction.OnRecordClick -> {
                                    if (context.hasRequiredPermissions()) {
                                        backStack.add(MediaRoute.RecordScreen)
                                    } else {
                                        ActivityCompat.requestPermissions(
                                            context.findActivity(), CAMERAX_PERMISSIONS, 0
                                        )
                                    }
                                }

                                else -> {}
                            }
                        }
                )
            }
            entry<MediaRoute.RecordScreen> {
                val vm: RecordViewModel = koinViewModel()
                val context = LocalContext.current
                val uiState by vm.uiState.collectAsState()

                CollectSideEffect(sideEffect = vm.sideEffect, onSideEffect = {
                    when (it) {
                        is RecordContract.SideEffect.ShowToast -> Toast.makeText(
                            context,
                            it.title,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

                RecordScreen(
                    uiState = uiState, onAction = vm::onAction
                )
            }
        })
}