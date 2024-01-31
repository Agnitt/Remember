package com.agnitt.remember.domain

import android.database.sqlite.SQLiteConstraintException
import com.agnitt.remember.models.domain.Category
import com.agnitt.remember.models.domain.Item

interface ItemInteractor {

    /** @throws SQLiteConstraintException если есть айтем с таким же тайтлом */
    suspend fun add(item: Item)

    suspend fun get(title: String): Item

    suspend fun getAll(): List<Item>

    suspend fun update(item: Item)

    suspend fun update(
        title: String,
        newTitle: String? = null,
        categoryID: Long? = null,
        currentQuantity: Int? = null,
        perTimeQuantity: Int? = null,
        dailyFactor: Int? = null,
        archived: Boolean? = null
    )

    suspend fun delete(title: String)

    suspend fun deleteAll()

}