package com.agnitt.remember.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.agnitt.remember.common.CATEGORY_TABLE_NAME
import com.agnitt.remember.common.FIELD_CATEGORY_COLOR
import com.agnitt.remember.common.FIELD_CATEGORY_ICON_ID
import com.agnitt.remember.common.FIELD_CATEGORY_INNER_ID
import com.agnitt.remember.common.FIELD_CATEGORY_TITLE
import com.agnitt.remember.models.data.db.CategoryEntity
import android.database.sqlite.SQLiteConstraintException

@Dao
interface CategoryDao {

    //region add
    /** @throws SQLiteConstraintException если есть категория с таким же тайтлом или id */
    @Insert
    suspend fun insert(vararg categories: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWithReplace(vararg categories: CategoryEntity)

    //endregion

    //region get
    @Query("SELECT * FROM $CATEGORY_TABLE_NAME ORDER BY $FIELD_CATEGORY_INNER_ID DESC")
    suspend fun getAllOrderByID(): List<CategoryEntity>

    @Query("SELECT * FROM $CATEGORY_TABLE_NAME ORDER BY $FIELD_CATEGORY_TITLE DESC")
    suspend fun getAllOrderByTitle(): List<CategoryEntity>

    @Query("SELECT * FROM $CATEGORY_TABLE_NAME WHERE $FIELD_CATEGORY_INNER_ID = :id")
    suspend fun getByID(id: Long): CategoryEntity

    @Query("SELECT * FROM $CATEGORY_TABLE_NAME WHERE $FIELD_CATEGORY_TITLE = :title")
    suspend fun getByTitle(title: String): CategoryEntity

    //endregion

    //region upd
    @Update
    suspend fun update(vararg categories: CategoryEntity)

    @Query(
        "UPDATE $CATEGORY_TABLE_NAME SET " +
                "$FIELD_CATEGORY_TITLE = :newTitle " +
                "WHERE $FIELD_CATEGORY_INNER_ID = :id"
    )
    suspend fun updateTitle(id: Long, newTitle: String)

    @Query(
        "UPDATE $CATEGORY_TABLE_NAME SET " +
                "$FIELD_CATEGORY_COLOR = :color " +
                "WHERE $FIELD_CATEGORY_INNER_ID = :id"
    )
    suspend fun updateColor(id: Long, color: Int)

    @Query(
        "UPDATE $CATEGORY_TABLE_NAME SET " +
                "$FIELD_CATEGORY_ICON_ID = :iconID " +
                "WHERE $FIELD_CATEGORY_INNER_ID = :id"
    )
    suspend fun updateIcon(id: Long, iconID: Int)

    //endregion

    // region del
    @Delete
    suspend fun delete(vararg categories: CategoryEntity)

    @Query("DELETE FROM $CATEGORY_TABLE_NAME WHERE $FIELD_CATEGORY_INNER_ID = :id")
    suspend fun deleteByID(id: Long)

    @Query("DELETE FROM $CATEGORY_TABLE_NAME WHERE $FIELD_CATEGORY_TITLE = :title")
    suspend fun deleteByTitle(title: String)

    @Query("DELETE FROM $CATEGORY_TABLE_NAME")
    suspend fun clearAll()

    //endregion
}