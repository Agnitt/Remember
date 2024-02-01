package com.agnitt.remember.data

import com.agnitt.remember.data.converter.ItemDatabaseToDomainConverter
import com.agnitt.remember.data.db.ItemDao
import com.agnitt.remember.domain.ItemsRepository
import com.agnitt.remember.domain.converter.ItemDomainToDatabaseConverter
import com.agnitt.remember.models.data.db.ItemEntity
import com.agnitt.remember.models.domain.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val itemsDao: ItemDao,
    private val fromDBConverter: ItemDatabaseToDomainConverter,
    private val toDBConverter: ItemDomainToDatabaseConverter,
) : ItemsRepository {

    private val dio = Dispatchers.IO

    override suspend fun add(item: Item, replace: Boolean) {
        withContext(dio) {
            item.toEntity().let {
                if (replace) {
                    itemsDao.insertWithReplace(it)
                } else {
                    itemsDao.insert(it)
                }
            }
        }
    }

    override suspend fun getAll(): List<Item> = withContext(dio) {
        itemsDao.getAllItems().toItems()
    }


    override suspend fun getActualItems(): List<Item> = withContext(dio) {
        itemsDao.getAllActualItems().toItems()
    }

    override suspend fun getArchive(): List<Item> = withContext(dio) {
        itemsDao.getAllArchivedItems().toItems()
    }

    override suspend fun getItemByTitle(title: String): Item = withContext(dio) {
        itemsDao.getByTitle(title).toItem()
    }

    override suspend fun getByCategory(categoryID: Long): List<Item> = withContext(dio) {
        itemsDao.getByCategory(categoryID).toItems()
    }

    override suspend fun update(item: Item) {
        withContext(dio) {
            itemsDao.update(item.toEntity())
        }
    }

    override suspend fun updateFields(title: String, newTitle: String?, categoryID: Long?) {
        withContext(dio) {
            newTitle?.let { itemsDao.updateTitle(title, newTitle) }
            categoryID?.let { itemsDao.updateCategory(title, categoryID) }
        }
    }

    override suspend fun updateCurrentQuantity(
        title: String,
        currentQuantity: String,
        dateTo: Long
    ) {
        withContext(dio) {
            itemsDao.updateCurrentQuantity(title, currentQuantity, dateTo)
        }
    }

    override suspend fun updatePerTimeQuantity(
        title: String,
        perTime: Int,
        perDay: Int,
        dateTo: Long
    ) {
        withContext(dio) {
            itemsDao.updatePerTimeQuantity(title, perTime, perDay, dateTo)
        }
    }

    override suspend fun updateDailyFactor(
        title: String,
        dailyFactor: Int,
        perDay: Int,
        dateTo: Long
    ) {
        withContext(dio) {
            itemsDao.updateDailyFactor(title, dailyFactor, perDay, dateTo)
        }
    }

    override suspend fun delete(item: Item) = deleteByTitle(item.title)


    override suspend fun deleteByTitle(title: String) {
        withContext(dio) {
            itemsDao.deleteByTitle(title)
        }
    }

    override suspend fun deleteByCategory(categoryID: Long) {
        withContext(dio) {
            itemsDao.deleteByCategory(categoryID)
        }
    }

    override suspend fun clearArchive() {
        withContext(dio) {
            itemsDao.clearArchive()
        }
    }

    override suspend fun clearAll() {
        withContext(dio) {
            itemsDao.clearAll()
        }
    }

    override suspend fun exist(title: String): Boolean = withContext(dio) {
        itemsDao.exist(title)
    }

    override suspend fun countItemsInCategory(categoryID: Long): Int =
        withContext(dio) {
            itemsDao.countByCategory(categoryID)
        }

    override suspend fun archive(title: String) {
        withContext(dio) {
            itemsDao.archive(title)
        }
    }

    override suspend fun unarchive(title: String) {
        withContext(dio) {
            itemsDao.unarchive(title)
        }
    }

    private fun Item.toEntity() = toDBConverter.convert(this)
    private fun List<Item>.toEntities() = this.map(toDBConverter::convert)
    private fun ItemEntity.toItem() = fromDBConverter.convert(this)
    private fun List<ItemEntity>.toItems() = this.map(fromDBConverter::convert)
}