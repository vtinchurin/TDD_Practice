package ru.easycode.zerotoheroandroidtdd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.easycode.zerotoheroandroidtdd.data.model.ItemCache

@Dao
interface ItemsDao {

    @Query("SELECT * FROM items")
    fun list(): List<ItemCache>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: ItemCache)

}