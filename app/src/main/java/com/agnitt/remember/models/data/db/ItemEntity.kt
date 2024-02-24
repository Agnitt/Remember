package com.agnitt.remember.models.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.agnitt.remember.common.FIELD_ITEM_ARCHIVED
import com.agnitt.remember.common.FIELD_ITEM_CATEGORY_ID
import com.agnitt.remember.common.FIELD_ITEM_CURRENT_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_DAILY_FACTOR
import com.agnitt.remember.common.FIELD_ITEM_DATE_FROM
import com.agnitt.remember.common.FIELD_ITEM_DATE_TO
import com.agnitt.remember.common.FIELD_ITEM_ID
import com.agnitt.remember.common.FIELD_ITEM_PER_DAY_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_PER_TIME_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_TITLE
import com.agnitt.remember.common.ITEM_TABLE_NAME
import java.io.Serializable
import java.time.LocalDateTime

/**
 * Модель айтема для дб
 *
 * @param title отображаемое название
 * @param categoryID id категории предмета
 * @param currentQuantity текущее количество
 * @param perTimeQuantity доза за раз
 * @param perDayQuantity количество используемое в день
 * @param dailyFactor количество доз в день
 * @param dateFrom дата добавления айтема в таблицу
 * @param dateTo дата окончания припасов
 * @param archived флаг перемещения в архив
 */
@Entity(
    tableName = ITEM_TABLE_NAME,
    indices = [
        Index(value = [FIELD_ITEM_ID]),
        Index(value = [FIELD_ITEM_TITLE], unique = true)
    ]
)
data class ItemEntity(
    @ColumnInfo(name = FIELD_ITEM_ID) @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = FIELD_ITEM_TITLE) val title: String,
    @ColumnInfo(name = FIELD_ITEM_CATEGORY_ID) val categoryID: Long?,
    @ColumnInfo(name = FIELD_ITEM_CURRENT_QUANTITY) val currentQuantity: Int,
    @ColumnInfo(name = FIELD_ITEM_PER_TIME_QUANTITY) val perTimeQuantity: Int,
    @ColumnInfo(name = FIELD_ITEM_PER_DAY_QUANTITY) val perDayQuantity: Int,
    @ColumnInfo(name = FIELD_ITEM_DAILY_FACTOR) val dailyFactor: Int,
    @ColumnInfo(name = FIELD_ITEM_DATE_FROM) val dateFrom: LocalDateTime,
    @ColumnInfo(name = FIELD_ITEM_DATE_TO) val dateTo: LocalDateTime,
    @ColumnInfo(name = FIELD_ITEM_ARCHIVED) val archived: Boolean
) : Serializable