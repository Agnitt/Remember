package com.agnitt.remember.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.agnitt.remember.common.FIELD_ITEM_ARCHIVED
import com.agnitt.remember.common.FIELD_ITEM_CATEGORY_ID
import com.agnitt.remember.common.FIELD_ITEM_CURRENT_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_DAILY_FACTOR
import com.agnitt.remember.common.FIELD_ITEM_DATE_TO
import com.agnitt.remember.common.FIELD_ITEM_ID
import com.agnitt.remember.common.FIELD_ITEM_PER_DAY_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_PER_TIME_QUANTITY
import com.agnitt.remember.common.FIELD_ITEM_TITLE
import com.agnitt.remember.common.ITEM_TABLE_NAME
import com.agnitt.remember.models.data.db.ItemEntity

@Dao
interface ItemDao {

    //region add
    @Insert
    suspend fun insert(vararg items: ItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWithReplace(vararg items: ItemEntity)

    //endregion

    //region get
    @Query("SELECT * FROM $ITEM_TABLE_NAME ORDER BY $FIELD_ITEM_ID DESC")
    suspend fun getAllItems(): List<ItemEntity>

    @Query("SELECT * FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_ARCHIVED = 0")
    suspend fun getAllActualItems(): List<ItemEntity>

    @Query("SELECT * FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_ARCHIVED = 1")
    suspend fun getAllArchivedItems(): List<ItemEntity>

    @Query("SELECT * FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_TITLE = :title")
    suspend fun getByTitle(title: String): ItemEntity

    @Query("SELECT * FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_CATEGORY_ID = :categoryID ")
    suspend fun getByCategory(categoryID: Long): List<ItemEntity>

    //endregion

    //region upd
    @Update
    suspend fun update(vararg items: ItemEntity)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_TITLE = :newTitle " +
                "WHERE $FIELD_ITEM_TITLE = :oldTitle"
    )
    suspend fun updateTitle(oldTitle: String, newTitle: String)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_CATEGORY_ID = :category " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun updateCategory(title: String, category: String)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_CURRENT_QUANTITY = :currentQuantity, " +
                "$FIELD_ITEM_DATE_TO = :dateTo " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun updateCurrentQuantity(title: String, currentQuantity: String, dateTo: Long)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_PER_TIME_QUANTITY = :perTime, " +
                "$FIELD_ITEM_PER_DAY_QUANTITY = :perDay, " +
                "$FIELD_ITEM_DATE_TO = :dateTo " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun updatePerTimeQuantity(title: String, perTime: Int, perDay: Int, dateTo: Long)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_DAILY_FACTOR = :dailyFactor, " +
                "$FIELD_ITEM_PER_DAY_QUANTITY = :perDay, " +
                "$FIELD_ITEM_DATE_TO = :dateTo " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun updateDailyFactor(title: String, dailyFactor: Int, perDay: Int, dateTo: Long)

    //endregion

    // region del
    @Delete
    suspend fun delete(vararg items: ItemEntity)

    @Query("DELETE FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_TITLE = :title")
    suspend fun deleteByTitle(title: String)

    @Query("DELETE FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_CATEGORY_ID = :categoryID")
    suspend fun deleteByCategory(categoryID: Long)

    @Query("DELETE FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_ARCHIVED = 1")
    suspend fun clearArchive()

    @Query("DELETE FROM $ITEM_TABLE_NAME")
    suspend fun clearAll()

    //endregion

    //region other
    @Query("SELECT EXISTS (SELECT * FROM $ITEM_TABLE_NAME WHERE $FIELD_ITEM_TITLE = :title)")
    suspend fun exist(title: String)

    @Query("SELECT COUNT($FIELD_ITEM_CATEGORY_ID) FROM $ITEM_TABLE_NAME")
    suspend fun countByCategory(categoryID: Long)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_ARCHIVED = 1 " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun archive(title: String)

    @Query(
        "UPDATE $ITEM_TABLE_NAME SET " +
                "$FIELD_ITEM_ARCHIVED = 0 " +
                "WHERE $FIELD_ITEM_TITLE = :title"
    )
    suspend fun unarchive(title: String)

    //endregion
}