package com.agnitt.remember.domain

import androidx.compose.ui.graphics.Color
import com.agnitt.remember.models.domain.Category
import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryInteractor {
    override suspend fun add(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun get(title: String): Category {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: Long): Category {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun update(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun update(title: String, newTitle: String?, color: Color?, iconID: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun update(innerID: Long, title: String?, color: Color?, iconID: Int?) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }


}