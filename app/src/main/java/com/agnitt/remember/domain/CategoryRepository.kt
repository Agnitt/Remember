package com.agnitt.remember.domain

import android.database.sqlite.SQLiteConstraintException
import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.domain.Category

interface CategoryRepository {

    /** @throws SQLiteConstraintException если есть категория с таким же тайтлом или id и флаг replace false */
    suspend fun add(category: Category, replace: Boolean = false)

    suspend fun getRootCategory(): Category

    suspend fun get(categoryID: Long): Category

    suspend fun get(title: String): Category

    suspend fun getAll(): List<Category>

    suspend fun update(category: Category)

    suspend fun update(
        categoryID: Long,
        title: String? = null,
        color: Color? = null,
        iconID: Int? = null
    )

    suspend fun delete(categoryID: Long)

    suspend fun delete(title: String)

    suspend fun deleteAll()
}