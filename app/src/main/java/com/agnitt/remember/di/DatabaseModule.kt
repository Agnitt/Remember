package com.agnitt.remember.di

import android.content.Context
import androidx.room.Room
import com.agnitt.remember.common.CATEGORY_DB_NAME
import com.agnitt.remember.common.ITEM_DB_NAME
import com.agnitt.remember.data.db.CategoriesDB
import com.agnitt.remember.data.db.CategoryDao
import com.agnitt.remember.data.db.ItemDao
import com.agnitt.remember.data.db.ItemsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideItemsDB(@ApplicationContext appContext: Context): ItemsDB {
        return Room.databaseBuilder(
            appContext.applicationContext,
            ItemsDB::class.java,
            ITEM_DB_NAME
        ).build()
    }

    @Provides
    fun provideItemDao(itemsDB: ItemsDB): ItemDao {
        return itemsDB.getDAO()
    }

    @Provides
    @Singleton
    fun provideCategoriesDB(@ApplicationContext appContext: Context): CategoriesDB {
        return Room.databaseBuilder(
            appContext.applicationContext,
            CategoriesDB::class.java,
            CATEGORY_DB_NAME
        ).build()
    }

    @Provides
    fun provideCategoryDao(categoriesDB: CategoriesDB): CategoryDao {
        return categoriesDB.getDAO()
    }
}