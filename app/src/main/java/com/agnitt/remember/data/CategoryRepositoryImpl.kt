package com.agnitt.remember.data

import androidx.compose.ui.graphics.Color
import com.agnitt.remember.data.converter.CategoryDatabaseToDomainConverter
import com.agnitt.remember.data.db.CategoryDao
import com.agnitt.remember.domain.CategoryRepository
import com.agnitt.remember.domain.converter.CategoryDomainToDatabaseConverter
import com.agnitt.remember.models.domain.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao,
    private val fromDBConverter: CategoryDatabaseToDomainConverter,
    private val toDBConverter: CategoryDomainToDatabaseConverter,
    private val dispatchers: Dispatchers
) : CategoryRepository {
    override suspend fun add(category: Category) = withContext(dispatchers.IO) {
        toDBConverter.convert(category).let { categoryDao.insert(it) }
    }

    override suspend fun get(categoryID: Long)  = withContext(dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun update(category: Category)  = withContext(dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun update(categoryID: Long, title: String?, color: Color?, iconID: Int?)  = withContext(dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(categoryID: Long)  = withContext(dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll()  = withContext(dispatchers.IO) {
        TODO("Not yet implemented")
    }

}