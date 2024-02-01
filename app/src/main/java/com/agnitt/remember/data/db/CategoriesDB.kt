package com.agnitt.remember.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.agnitt.remember.models.data.db.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
abstract class CategoriesDB : RoomDatabase() {
    abstract fun getDAO(): CategoryDao

}