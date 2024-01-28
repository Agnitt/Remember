package com.agnitt.remember.domain

import com.agnitt.remember.models.domain.Item

interface ItemsRepository {
    suspend fun add(item: Item)
    suspend fun getAll(): List<Item>
    suspend fun getActualItems(): List<Item>
    suspend fun getArchive(): List<Item>
    suspend fun getItemByID(id: Long): Item
    suspend fun getItemByTitle(title: String): Item
    suspend fun getByCategory(categoryID: Long): List<Item>
    suspend fun update(item: Item)
    suspend fun updateFields(title: String, newTitle: String? = null, categoryID: Long? = null)
    suspend fun updateCurrentQuantity(title: String, currentQuantity: String, dateTo: Long)
    suspend fun updatePerTimeQuantity(title: String, perTime: Int, perDay: Int, dateTo: Long)
    suspend fun updateDailyFactor(title: String, dailyFactor: Int, perDay: Int, dateTo: Long)
    suspend fun delete(item: Item)
    suspend fun deleteByTitle(title: String)
    suspend fun deleteByCategory(categoryID: Long)
    suspend fun clearArchive()
    suspend fun clearAll()
    suspend fun exist(title: String)
    suspend fun countItemsInCategory(categoryID: Long)
    suspend fun archive(title: String)
    suspend fun unarchive(title: String)
}