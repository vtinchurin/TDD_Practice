package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.Core
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.ViewModelFactory
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDataBase
import ru.easycode.zerotoheroandroidtdd.data.repository.Now

class App:Application(),ProvideViewModel {

    private lateinit var factory : ViewModelFactory
    private lateinit var provideViewModel:ProvideViewModel
    lateinit var db:Core
    private val clear : ClearViewModel  = object : ClearViewModel {
        override fun clearViewModel(clasz: Class<out ViewModel>) {
            factory.clearViewModel(clasz)
        }

    }

    override fun onCreate() {
        super.onCreate()
        val db = Core(this.applicationContext)
        provideViewModel = ProvideViewModel.Base(clear, db.dao(),Now.Base())
        factory = ViewModelFactory.Base(provideViewModel)

    }



    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
    }



}