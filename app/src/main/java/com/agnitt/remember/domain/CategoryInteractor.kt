package com.agnitt.remember.domain

import android.database.sqlite.SQLiteConstraintException
import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.domain.Category

interface CategoryInteractor {

    /** @throws SQLiteConstraintException если есть категория с таким же тайтлом или id */
    suspend fun add(category: Category)

    suspend fun get(title: String): Category

    suspend fun get(id: Long): Category

    suspend fun getAll(): List<Category>

    suspend fun update(category: Category)

    suspend fun update(
        innerID: Long,
        title: String? = null,
        color: Color? = null,
        iconID: Int? = null
    )

    suspend fun delete(title: String)

    suspend fun delete(id: Long)

    suspend fun deleteAll()

}