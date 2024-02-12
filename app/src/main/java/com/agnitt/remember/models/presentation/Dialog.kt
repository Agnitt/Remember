package com.agnitt.remember.models.presentation

sealed interface Dialog {

    /**
     * Обозначение отсутствия диалога
     */
    object Nothing : Dialog

    data class Error(val error: Throwable): Dialog

// permissions, requests, attention ...
}