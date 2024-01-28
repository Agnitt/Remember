package com.agnitt.remember.data

import com.agnitt.remember.data.converter.CategoryDatabaseToDomainConverter
import com.agnitt.remember.data.converter.ItemDatabaseToDomainConverter
import com.agnitt.remember.data.db.CategoryDao
import com.agnitt.remember.data.db.ItemDao
import com.agnitt.remember.domain.ItemsRepository
import com.agnitt.remember.domain.converter.CategoryDomainToDatabaseConverter
import com.agnitt.remember.domain.converter.ItemDomainToDatabaseConverter
import com.agnitt.remember.models.domain.Item
import kotlinx.coroutines.Dispatchers

class ItemsRepositoryImpl(
    private val itemsDao: ItemDao,
    private val fromDBConverter: ItemDatabaseToDomainConverter,
    private val toDBConverter: ItemDomainToDatabaseConverter,
    private val dispatchers: Dispatchers
) : ItemsRepository  {
    override suspend fun add(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun getActualItems(): List<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun getArchive(): List<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun getItemByID(id: Long): Item {
        TODO("Not yet implemented")
    }

    override suspend fun getItemByTitle(title: String): Item {
        TODO("Not yet implemented")
    }

    override suspend fun getByCategory(categoryID: Long): List<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun update(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun updateFields(title: String, newTitle: String?, categoryID: Long?) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCurrentQuantity(
        title: String,
        currentQuantity: String,
        dateTo: Long
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePerTimeQuantity(
        title: String,
        perTime: Int,
        perDay: Int,
        dateTo: Long
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDailyFactor(
        title: String,
        dailyFactor: Int,
        perDay: Int,
        dateTo: Long
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteByTitle(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteByCategory(categoryID: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun clearArchive() {
        TODO("Not yet implemented")
    }

    override suspend fun clearAll() {
        TODO("Not yet implemented")
    }

    override suspend fun exist(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun countItemsInCategory(categoryID: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun archive(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun unarchive(title: String) {
        TODO("Not yet implemented")
    }

}