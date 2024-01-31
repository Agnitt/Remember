package com.agnitt.remember.domain

import com.agnitt.remember.models.domain.Category
import com.agnitt.remember.models.domain.Item

interface CommonInteractor {

    suspend fun getAllCategoriesContent(): Map<Category, List<Item>>

    suspend fun getCategoryContent(categoryID: Long): List<Item>

    suspend fun categoryContentIsEmpty(categoryID: Long): Boolean

    suspend fun clearCategoryContent(categoryID: Long)
}