package com.agnitt.remember.models.presentation

import com.agnitt.remember.presentation.viewmodels.MainViewModel

sealed interface MainScreenState {

    /**
     * Начальное состояние
     */
    object Idle : MainScreenState

    /**
     * Загрузка экрана
     */
    object Loading : MainScreenState

    /**
     * Загрузка данных успешно завершена
     *
     */
    data class Complete(val mainViewModel: MainViewModel) : MainScreenState
}