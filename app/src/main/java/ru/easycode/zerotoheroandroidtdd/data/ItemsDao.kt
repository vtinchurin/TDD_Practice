package ru.easycode.zerotoheroandroidtdd.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ItemsDao {

    @Query("SELECT * FROM items")
    fun list(): List<ItemCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: ItemCache)

    @Query("DELETE FROM items WHERE id = :id")
    fun delete(id: Long)

    @Query("SELECT * FROM items WHERE id = :id")
    fun item(id: Long): ItemCache
}
