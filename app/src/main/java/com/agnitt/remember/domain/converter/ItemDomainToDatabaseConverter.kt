package com.agnitt.remember.domain.converter

import com.agnitt.remember.models.data.db.ItemEntity
import com.agnitt.remember.models.domain.Item
import javax.inject.Inject

class ItemDomainToDatabaseConverter @Inject constructor() {

    fun convert(from: Item): ItemEntity = ItemEntity(
        title = from.title,
        categoryID = from.category?.innerID,
        currentQuantity = from.currentQuantity,
        perTimeQuantity = from.perTimeQuantity,
        perDayQuantity = from.perDayQuantity,
        dailyFactor = from.dailyFactor,
        dateFrom = from.dateFrom,
        dateTo = from.dateTo,
        archived = from.archived
    )
}