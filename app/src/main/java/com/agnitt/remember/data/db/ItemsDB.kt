package com.agnitt.remember.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agnitt.remember.data.converter.LocalDateTimeConverter
import com.agnitt.remember.models.data.db.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class ItemsDB : RoomDatabase() {
    abstract fun getDAO(): ItemDao

}