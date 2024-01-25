package com.agnitt.remember.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    val isDarkTheme = mutableStateOf(false) // add dynamic
}