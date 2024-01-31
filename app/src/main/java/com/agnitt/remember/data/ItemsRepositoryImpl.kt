package com.agnitt.remember.data

import com.agnitt.remember.data.converter.ItemDatabaseToDomainConverter
import com.agnitt.remember.data.db.ItemDao
import com.agnitt.remember.domain.ItemsRepository
import com.agnitt.remember.domain.converter.ItemDomainToDatabaseConverter
import com.agnitt.remember.models.data.db.ItemEntity
import com.agnitt.remember.models.domain.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class ItemsRepositoryImpl(
    private val itemsDao: ItemDao,
    private val fromDBConverter: ItemDatabaseToDomainConverter,
    private val toDBConverter: ItemDomainToDatabaseConverter,
    private val dispatchers: Dispatchers
) : ItemsRepository {

    override suspend fun add(item: Item, replace: Boolean) {
        withContext(dispatchers.IO) {
            item.toEntity().let {
                if (replace) {
                    itemsDao.insertWithReplace(it)
                } else {
                    itemsDao.insert(it)
                }
            }
        }
    }

    override suspend fun getAll(): List<Item> = withContext(dispatchers.IO) {
        itemsDao.getAllItems().toItems()
    }


    override suspend fun getActualItems(): List<Item> = withContext(dispatchers.IO) {
        itemsDao.getAllActualItems().toItems()
    }

    override suspend fun getArchive(): List<Item> = withContext(dispatchers.IO) {
        itemsDao.getAllArchivedItems().toItems()
    }

    override suspend fun getItemByTitle(title: String): Item = withContext(dispatchers.IO) {
        itemsDao.getByTitle(title).toItem()
    }

    override suspend fun getByCategory(categoryID: Long): List<Item> = withContext(dispatchers.IO) {
        itemsDao.getByCategory(categoryID).toItems()
    }

    override suspend fun update(item: Item) {
        withContext(dispatchers.IO) {
            itemsDao.update(item.toEntity())
        }
    }

    override suspend fun updateFields(title: String, newTitle: String?, categoryID: Long?) {
        withContext(dispatchers.IO) {
            newTitle?.let { itemsDao.updateTitle(title, newTitle) }
            categoryID?.let { itemsDao.updateCategory(title, categoryID) }
        }
    }

    override suspend fun updateCurrentQuantity(
        title: String,
        currentQuantity: String,
        dateTo: Long
    ) {
        withContext(dispatchers.IO) {
            itemsDao.updateCurrentQuantity(title, currentQuantity, dateTo)
        }
    }

    override suspend fun updatePerTimeQuantity(
        title: String,
        perTime: Int,
        perDay: Int,
        dateTo: Long
    ) {
        withContext(dispatchers.IO) {
            itemsDao.updatePerTimeQuantity(title, perTime, perDay, dateTo)
        }
    }

    override suspend fun updateDailyFactor(
        title: String,
        dailyFactor: Int,
        perDay: Int,
        dateTo: Long
    ) {
        withContext(dispatchers.IO) {
            itemsDao.updateDailyFactor(title, dailyFactor, perDay, dateTo)
        }
    }

    override suspend fun delete(item: Item) = deleteByTitle(item.title)


    override suspend fun deleteByTitle(title: String) {
        withContext(dispatchers.IO) {
            itemsDao.deleteByTitle(title)
        }
    }

    override suspend fun deleteByCategory(categoryID: Long) {
        withContext(dispatchers.IO) {
            itemsDao.deleteByCategory(categoryID)
        }
    }

    override suspend fun clearArchive() {
        withContext(dispatchers.IO) {
            itemsDao.clearArchive()
        }
    }

    override suspend fun clearAll() {
        withContext(dispatchers.IO) {
            itemsDao.clearAll()
        }
    }

    override suspend fun exist(title: String): Boolean = withContext(dispatchers.IO) {
        itemsDao.exist(title)
    }

    override suspend fun countItemsInCategory(categoryID: Long): Int =
        withContext(dispatchers.IO) {
            itemsDao.countByCategory(categoryID)
        }

    override suspend fun archive(title: String) {
        withContext(dispatchers.IO) {
            itemsDao.archive(title)
        }
    }

    override suspend fun unarchive(title: String) {
        withContext(dispatchers.IO) {
            itemsDao.unarchive(title)
        }
    }

    private fun Item.toEntity() = toDBConverter.convert(this)
    private fun List<Item>.toEntities() = this.map(toDBConverter::convert)
    private fun ItemEntity.toItem() = fromDBConverter.convert(this)
    private fun List<ItemEntity>.toItems() = this.map(fromDBConverter::convert)
}