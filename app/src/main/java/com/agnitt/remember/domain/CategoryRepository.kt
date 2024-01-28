package com.agnitt.remember.domain

import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.domain.Category

interface CategoryRepository {

    suspend fun add(category: Category)

    suspend fun get(categoryID: Long)

    suspend fun update(category: Category)

    suspend fun update(
        categoryID: Long,
        title: String?,
        color: Color?,
        iconID: Int?
    )

    suspend fun delete(categoryID: Long)

    suspend fun deleteAll()
}