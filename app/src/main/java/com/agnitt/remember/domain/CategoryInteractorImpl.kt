package com.agnitt.remember.domain

import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.domain.Category
import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryInteractor {
    override suspend fun add(category: Category) {
        categoryRepository.add(category, true)
    }

    override suspend fun get(title: String): Category = categoryRepository.get(title)

    override suspend fun get(id: Long): Category = categoryRepository.get(id)

    override suspend fun getAll(): List<Category> = categoryRepository.getAll()

    override suspend fun update(category: Category) {
        categoryRepository.update(category)
    }

    override suspend fun update(innerID: Long, title: String?, color: Color?, iconID: Int?) {
        categoryRepository.update(innerID, title, color, iconID)
    }

    override suspend fun delete(title: String) {
        categoryRepository.delete(title)
    }

    override suspend fun delete(id: Long) {
        categoryRepository.delete(id)
    }

    override suspend fun deleteAll() {
        categoryRepository.deleteAll()
    }


}