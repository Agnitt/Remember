@file:OptIn(ExperimentalMaterial3Api::class)

package com.agnitt.remember.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.agnitt.remember.presentation.components.ActionButton
import com.agnitt.remember.presentation.components.BottomBar
import com.agnitt.remember.presentation.components.SnackBar
import com.agnitt.remember.presentation.components.TopBar
import com.agnitt.remember.presentation.theme.RememberTheme

@Composable
fun MainScreen(isDarkThemeState: MutableState<Boolean>) {

    val isDarkTheme by remember { isDarkThemeState }

    RememberTheme(isDarkTheme) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() },
            bottomBar = { BottomBar() },
            snackbarHost = { SnackBar() },
            floatingActionButton = { ActionButton(isDarkThemeState) },
            floatingActionButtonPosition = FabPosition.End,
            containerColor = MaterialTheme.colorScheme.background,
//        contentColor: Color,
//        contentWindowInsets: WindowInsets,
        ) {
            Box(
                modifier = Modifier.padding(it),
                contentAlignment = Alignment.Center
            ) {
                Greeting("I hate it cuz feel self so stupid and embarrassed")
            }

        }
    }
}
