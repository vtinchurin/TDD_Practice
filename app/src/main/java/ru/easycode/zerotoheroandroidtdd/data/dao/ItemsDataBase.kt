package ru.easycode.zerotoheroandroidtdd.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.easycode.zerotoheroandroidtdd.data.model.ItemCache

@Database(entities = [ItemCache::class], version = 1)
abstract class ItemsDataBase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao

}

