package com.agnitt.remember.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.agnitt.remember.data.converter.CategoryDatabaseToDomainConverter
import com.agnitt.remember.data.db.CategoryDao
import com.agnitt.remember.domain.CategoryRepository
import com.agnitt.remember.domain.converter.CategoryDomainToDatabaseConverter
import com.agnitt.remember.models.domain.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao,
    private val fromDBConverter: CategoryDatabaseToDomainConverter,
    private val toDBConverter: CategoryDomainToDatabaseConverter,
    private val dispatchers: Dispatchers
) : CategoryRepository {

    override suspend fun add(category: Category, replace: Boolean) {
        withContext(dispatchers.IO) {
            toDBConverter.convert(category).let {
                if (replace) {
                    categoryDao.insertWithReplace(it)
                } else {
                    categoryDao.insert(it)
                }
            }
        }
    }

    override suspend fun get(categoryID: Long) = withContext(dispatchers.IO) {
        categoryDao.getByID(categoryID).let(fromDBConverter::convert)
    }

    override suspend fun update(category: Category) {
        withContext(dispatchers.IO) {
            toDBConverter.convert(category).let { categoryDao.update(it) }
        }
    }

    override suspend fun update(categoryID: Long, title: String?, color: Color?, iconID: Int?) {
        withContext(dispatchers.IO) {
            title?.let { categoryDao.updateTitle(categoryID, it) }
            color?.toArgb()?.let { categoryDao.updateColor(categoryID, it) }
            iconID?.let { categoryDao.updateIcon(categoryID, it) }
        }
    }

    override suspend fun delete(categoryID: Long) {
        withContext(dispatchers.IO) {
            categoryDao.deleteByID(categoryID)
        }
    }

    override suspend fun deleteAll() {
        withContext(dispatchers.IO) {
            categoryDao.clearAll()
        }
    }
}