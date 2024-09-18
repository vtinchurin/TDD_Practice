package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room
import ru.easycode.zerotoheroandroidtdd.data.ItemsDataBase

interface Core {

    class Base(context: Context) : Core {

        val db = Room.inMemoryDatabaseBuilder(context, ItemsDataBase::class.java)
            .allowMainThreadQueries()
            .build()

        val dao = db.itemsDao()

    }
}