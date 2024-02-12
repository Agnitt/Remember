package com.agnitt.remember.models.presentation

/**
 * Дополнительные окна, показываемые поверх основной страницы
 */
sealed interface AdditionalWindow {

    /**
     * Обозначение отсутствия доп окна
     */
    object Nothing : AdditionalWindow

    object AddItem : AdditionalWindow

    object AddCategory : AdditionalWindow

    data class ItemCard(val title: String) : AdditionalWindow

    data class CategoryCard(val id: Long) : AdditionalWindow
}