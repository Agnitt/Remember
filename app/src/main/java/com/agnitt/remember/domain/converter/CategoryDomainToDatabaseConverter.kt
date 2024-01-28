package com.agnitt.remember.domain.converter

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.agnitt.remember.models.data.db.CategoryEntity
import com.agnitt.remember.models.domain.Category

class CategoryDomainToDatabaseConverter {
    fun convert(from: Category): CategoryEntity = CategoryEntity(
        innerID = from.innerID,
        title = from.title,
        color = from.color?.toArgb() ?: Color.Transparent.toArgb(),
        iconId = from.iconID ?: 0
    )
}