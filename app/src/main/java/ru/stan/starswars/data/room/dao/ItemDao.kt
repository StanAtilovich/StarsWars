package ru.stan.starswars.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.stan.starswars.data.room.entity.ItemDbModel

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<ItemDbModel>

    @Query("SELECT * FROM items WHERE type=:type")
    suspend fun getAllItemsByType(type: String): List<ItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemDbModel: ItemDbModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateItem(itemDbModel: ItemDbModel)

    @Query("DELETE FROM items WHERE name=:name AND type=:type")
    suspend fun removeItem(name: String, type: String)
}