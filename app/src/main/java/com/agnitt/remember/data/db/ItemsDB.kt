package com.agnitt.remember.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.agnitt.remember.common.ITEM_DB_NAME
import com.agnitt.remember.models.data.db.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class ItemsDB : RoomDatabase() {
    abstract fun getDAO(): ItemDao

}