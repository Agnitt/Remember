package com.agnitt.remember.domain

import com.agnitt.remember.models.domain.Item
import java.util.Calendar
import java.util.Date

internal class ItemInteractorImpl(
    private val itemRepository: ItemsRepository
) : ItemInteractor {
    override suspend fun add(item: Item) = itemRepository.add(item)

    override suspend fun get(title: String): Item = itemRepository.getItemByTitle(title)

    override suspend fun getAll(): List<Item> = itemRepository.getAll()

    override suspend fun update(item: Item) = itemRepository.update(item)

    override suspend fun update(
        title: String,
        newTitle: String?,
        categoryID: Long?,
        currentQuantity: Int?,
        perTimeQuantity: Int?,
        dailyFactor: Int?,
        archived: Boolean?
    ) {
        updateSimpleFields(title, newTitle, categoryID)
    }

    override suspend fun delete(title: String) = itemRepository.deleteByTitle(title)

    override suspend fun deleteAll() = itemRepository.clearAll()

    private suspend fun updateSimpleFields(
        title: String,
        newTitle: String?,
        categoryID: Long?
    ) {
        if (newTitle != null || categoryID != null) {
            itemRepository.updateFields(title, newTitle, categoryID)
        }
    }

//    private suspend fun updateCurrentQuantity(
//        title: String,
//        currentQuantity: String
//    ) {

//    }
//
//    private suspend fun updatePerTimeQuantity(
//        title: String,
//        perTime: Int,
//        perDay: Int,
//        dateTo: Long
//    ) {
//
//    }
//
//    private suspend fun updateDailyFactor(
//        title: String,
//        dailyFactor: Int,
//        perDay: Int,
//        dateTo: Long
//    ) {
//
//    }
}