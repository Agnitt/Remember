package com.agnitt.remember.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier


@Composable
fun ActionButton(isDarkTheme: MutableState<Boolean>, modifier: Modifier = Modifier) = ThemeToggle(isDarkTheme, modifier)
//floatingActionButton: @Composable () -> Unit,
//floatingActionButtonPosition: FabPosition,