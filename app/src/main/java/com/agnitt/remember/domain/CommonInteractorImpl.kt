package com.agnitt.remember.domain

import com.agnitt.remember.models.domain.Category
import com.agnitt.remember.models.domain.Item

class CommonInteractorImpl: CommonInteractor {
    override suspend fun getAllCategoriesContent(): Map<Category, List<Item>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryContent(categoryID: Long): List<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun categoryContentIsEmpty(categoryID: Long): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun clearCategoryContent(categoryID: Long) {
        TODO("Not yet implemented")
    }

}