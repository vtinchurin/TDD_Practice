package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.ViewModelFactory
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDataBase

class App:Application(),ProvideViewModel {

    private lateinit var factory : ViewModelFactory
    private lateinit var provideViewModel:ProvideViewModel
    private object clear : ClearViewModel {
        override fun clearViewModel(clasz: Class<out ViewModel>) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate() {
        super.onCreate()

        factory = ViewModelFactory.Base()
    }



    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
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