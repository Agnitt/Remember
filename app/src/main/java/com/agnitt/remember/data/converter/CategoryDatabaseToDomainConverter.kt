package com.agnitt.remember.data.converter

import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.data.db.CategoryEntity
import com.agnitt.remember.models.domain.Category

internal class CategoryDatabaseToDomainConverter {

    fun convert(from: CategoryEntity): Category = Category(
        innerID = from.innerID,
        title = from.title,
        color = Color(from.color).takeIf { it != Color.Transparent },
        iconID = from.iconId.takeIf { it != 0 }
    )
}