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

    companion object {
        @Volatile
        private var instance: ItemsDB? = null

        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: createDB(context)
        }

        private fun createDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ItemsDB::class.java,
            ITEM_DB_NAME
        ).build()
    }
}