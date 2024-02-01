package com.agnitt.remember.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.agnitt.remember.domain.CategoryInteractor
import com.agnitt.remember.domain.CommonInteractor
import com.agnitt.remember.domain.ItemInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemInteractor: ItemInteractor,
    private val categoryInteractor: CategoryInteractor,
    private val commonInteractor: CommonInteractor
) : ViewModel() {
    val isDarkTheme = mutableStateOf(false) // add dynamic
}