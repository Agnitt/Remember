package com.agnitt.remember.domain

import android.database.sqlite.SQLiteConstraintException
import com.agnitt.remember.models.domain.Item
import java.time.LocalDateTime

interface ItemsRepository {

    /** @throws SQLiteConstraintException если есть айтем с таким же тайтлом и флаг replace false */
    suspend fun add(item: Item, replace: Boolean = false)
    suspend fun getAll(): List<Item>
    suspend fun getActualItems(): List<Item>
    suspend fun getArchive(): List<Item>
    suspend fun getItemByTitle(title: String): Item
    suspend fun getByCategory(categoryID: Long): List<Item>
    suspend fun update(item: Item)
    suspend fun updateFields(title: String, newTitle: String? = null, categoryID: Long? = null)
    suspend fun updateCurrentQuantity(title: String, currentQuantity: String, dateTo: LocalDateTime)
    suspend fun updatePerTimeQuantity(
        title: String,
        perTime: Int,
        perDay: Int,
        dateTo: LocalDateTime
    )

    suspend fun updateDailyFactor(
        title: String,
        dailyFactor: Int,
        perDay: Int,
        dateTo: LocalDateTime
    )

    suspend fun delete(item: Item)
    suspend fun deleteByTitle(title: String)
    suspend fun deleteByCategory(categoryID: Long)
    suspend fun clearArchive()
    suspend fun clearAll()
    suspend fun exist(title: String): Boolean
    suspend fun countItemsInCategory(categoryID: Long): Int
    suspend fun archive(title: String)
    suspend fun unarchive(title: String)
}