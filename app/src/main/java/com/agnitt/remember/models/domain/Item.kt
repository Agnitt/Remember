package com.agnitt.remember.models.domain

import java.time.LocalDateTime

/**
 * Модель айтема
 *
 * @param title отображаемое название
 * @param category категория предмета
 * @param currentQuantity текущее количество
 * @param perTimeQuantity доза за раз
 * @param perDayQuantity количество используемое в день
 * @param dailyFactor количество доз в день
 * @param dateFrom дата добавления айтема
 * @param dateTo дата окончания припасов
 * @param archived флаг перемещения в архив
 */
data class Item(
    val title: String,
    val category: Category? = null,
    var currentQuantity: Int,
    val perTimeQuantity: Int,
    val perDayQuantity: Int,
    val dailyFactor: Int,
    val dateFrom: LocalDateTime,
    val dateTo: LocalDateTime,
    val archived: Boolean
)