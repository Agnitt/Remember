package com.agnitt.remember.data.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
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