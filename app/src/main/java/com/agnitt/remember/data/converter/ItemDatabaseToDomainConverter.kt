package com.agnitt.remember.data.converter

import com.agnitt.remember.models.data.db.ItemEntity
import com.agnitt.remember.models.domain.Item

class ItemDatabaseToDomainConverter {

    fun convert(from: ItemEntity): Item = Item(
        title = from.title,
        currentQuantity = from.currentQuantity,
        perTimeQuantity = from.perTimeQuantity,
        perDayQuantity = from.perDayQuantity,
        dailyFactor = from.dailyFactor,
        dateFrom = from.dateFrom,
        dateTo = from.dateTo,
        archived = from.archived
    )
}