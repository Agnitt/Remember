package com.agnitt.remember.models.data.db

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.agnitt.remember.common.FIELD_CATEGORY_ID
import com.agnitt.remember.common.FIELD_CATEGORY_INNER_ID
import com.agnitt.remember.common.FIELD_ITEM_CATEGORY_ID
import com.agnitt.remember.models.domain.Category

class InfoFromDBByCategory {
    @Embedded
    var category: CategoryEntity? = null

    @Relation(
        parentColumn = FIELD_CATEGORY_INNER_ID,
        entity = ItemEntity::class,
        entityColumn = FIELD_ITEM_CATEGORY_ID
    )
    var content: List<ItemEntity> = emptyList()
}