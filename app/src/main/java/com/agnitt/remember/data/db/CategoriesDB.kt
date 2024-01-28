package com.agnitt.remember.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.agnitt.remember.common.CATEGORY_DB_NAME
import com.agnitt.remember.models.data.db.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
abstract class CategoriesDB : RoomDatabase() {
    abstract fun getDAO(): CategoryDao

    companion object {
        @Volatile
        private var instance: CategoriesDB? = null

        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: createDB(context)
        }

        private fun createDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CategoriesDB::class.java,
            CATEGORY_DB_NAME
        ).build()
    }
}