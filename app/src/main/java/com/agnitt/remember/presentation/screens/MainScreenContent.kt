package com.agnitt.remember.presentation.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.agnitt.remember.models.presentation.AdditionalWindow
import com.agnitt.remember.models.presentation.Dialog
import com.agnitt.remember.models.presentation.MainScreenState
import com.agnitt.remember.presentation.components.ErrorDialog
import com.agnitt.remember.presentation.theme.RememberTheme
import com.agnitt.remember.presentation.viewmodels.MainViewModel

@Composable
fun MainScreenContent(mainViewModel: MainViewModel) {
    val isDarkTheme by remember { mainViewModel.isDarkTheme }
    val mainScreenState by mainViewModel.state
    val dialogState by mainViewModel.dialog
    val windowState by mainViewModel.window

    RememberTheme(isDarkTheme) {

        Crossfade(
            targetState = mainScreenState,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            label = "MainContent"
        ) { state ->
            when (state) {

                MainScreenState.Idle -> LaunchedEffect(Unit) { mainViewModel.initialize() }
                MainScreenState.Loading -> MainScreenShimmer(isDarkTheme)
//                is MainScreenState.Complete -> MainScreen(mainViewModel.isDarkTheme)
                is MainScreenState.Complete -> TestScreen(mainViewModel)
            }
        }

        Crossfade(
            targetState = dialogState,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            label = "DialogContent"
        ) { state ->
            when (state) {
                is Dialog.Error -> ErrorDialog(error = state.error)
                Dialog.Nothing -> {}
            } //some fun
        }

        Crossfade(
            targetState = windowState,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            label = "DialogContent"
        ) { state ->
            when (state) {
                AdditionalWindow.Nothing -> {}
                AdditionalWindow.AddCategory -> TODO()
                AdditionalWindow.AddItem -> TODO()
                is AdditionalWindow.ItemCard -> TODO()
                is AdditionalWindow.CategoryCard -> TODO()
            } //some fun
        }


    }
}