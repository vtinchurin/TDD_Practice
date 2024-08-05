package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDataBase

class Core(
    val context: Context
) {
    fun build(): ItemsDataBase {
        val db = Room.databaseBuilder(
            context,
            ItemsDataBase::class.java,
            "database"
        ).build()

        return db
    }

    fun dao():ItemsDao{
        return build().itemsDao()
    }
}