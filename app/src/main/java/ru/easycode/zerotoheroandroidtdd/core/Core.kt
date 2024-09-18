package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room
import ru.easycode.zerotoheroandroidtdd.data.ItemsDataBase

interface Core {

    class Base(private val context: Context) : Core {

        fun build(): ItemsDataBase {
            val db = Room.inMemoryDatabaseBuilder(context, ItemsDataBase::class.java)
                .allowMainThreadQueries()
                .build()
            return db
        }
    }
}