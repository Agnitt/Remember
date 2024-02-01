package com.agnitt.remember.models.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.agnitt.remember.common.CATEGORY_TABLE_NAME
import com.agnitt.remember.common.FIELD_CATEGORY_COLOR
import com.agnitt.remember.common.FIELD_CATEGORY_ICON_ID
import com.agnitt.remember.common.FIELD_CATEGORY_ID
import com.agnitt.remember.common.FIELD_CATEGORY_INNER_ID
import com.agnitt.remember.common.FIELD_CATEGORY_TITLE
import java.io.Serializable

@Entity(
    tableName = CATEGORY_TABLE_NAME,
    indices = [
        Index(value = [FIELD_CATEGORY_INNER_ID], unique = true),
        Index(value = [FIELD_CATEGORY_TITLE], unique = true)
    ]
)
data class CategoryEntity(
    @ColumnInfo(name = FIELD_CATEGORY_INNER_ID) val innerID: Long,
    @ColumnInfo(name = FIELD_CATEGORY_TITLE) val title: String,
    @ColumnInfo(name = FIELD_CATEGORY_COLOR) val color: Int,
    @ColumnInfo(name = FIELD_CATEGORY_ICON_ID) val iconId: Int
) : Serializable {

    @ColumnInfo(name = FIELD_CATEGORY_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
}