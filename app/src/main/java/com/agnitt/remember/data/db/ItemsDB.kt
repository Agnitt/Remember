package com.agnitt.remember.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agnitt.remember.models.data.db.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class ItemsDB : RoomDatabase() {
    abstract fun getDAO(): ItemDao

}