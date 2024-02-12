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
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val fromDBConverter: CategoryDatabaseToDomainConverter,
    private val toDBConverter: CategoryDomainToDatabaseConverter,
) : CategoryRepository {

    private val dio = Dispatchers.IO
    override suspend fun add(category: Category, replace: Boolean) {
        withContext(dio) {
            toDBConverter.convert(category).let {
                if (replace) {
                    categoryDao.insertWithReplace(it)
                } else {
                    categoryDao.insert(it)
                }
            }
        }
    }

    override suspend fun get(categoryID: Long) = withContext(dio) {
        categoryDao.getByID(categoryID).let(fromDBConverter::convert)
    }

    override suspend fun get(title: String): Category = withContext(dio) {
        categoryDao.getByTitle(title).let(fromDBConverter::convert)
    }

    override suspend fun getAll(): List<Category> = withContext(dio) {
        categoryDao.getAllOrderByID().map(fromDBConverter::convert)
    }

    override suspend fun update(category: Category) {
        withContext(dio) {
            toDBConverter.convert(category).let { categoryDao.update(it) }
        }
    }

    override suspend fun update(categoryID: Long, title: String?, color: Color?, iconID: Int?) {
        withContext(dio) {
            title?.let { categoryDao.updateTitle(categoryID, it) }
            color?.toArgb()?.let { categoryDao.updateColor(categoryID, it) }
            iconID?.let { categoryDao.updateIcon(categoryID, it) }
        }
    }

    override suspend fun delete(categoryID: Long) {
        withContext(dio) {
            categoryDao.deleteByID(categoryID)
        }
    }

    override suspend fun delete(title: String) {
        withContext(dio) {
            categoryDao.deleteByTitle(title)
        }
    }

    override suspend fun deleteAll() {
        withContext(dio) {
            categoryDao.clearAll()
        }
    }
}