package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDataBase

class App:Application() {



    override fun onCreate() {
        super.onCreate()
    }

    companion object DataBase{

        fun build(): ItemsDataBase {
            val db = Room.databaseBuilder(
                getApplicationContext(),
                ItemsDataBase::class.java, "database"
            ).build()

            return db
        }

    }


}