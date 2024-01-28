package com.agnitt.remember.models.domain

import androidx.compose.ui.graphics.Color

data class Category(
    val innerID: Long,
    val title: String,
    val color: Color? = null,
    val iconID: Int? = null
)