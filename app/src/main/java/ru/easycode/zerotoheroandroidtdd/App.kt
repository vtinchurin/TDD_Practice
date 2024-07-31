package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.ViewModelFactory
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class App:Application(),ProvideViewModel {


    private lateinit var factory: ViewModelFactory
    private val clear : ClearViewModel = object : ClearViewModel{
        override fun clear(viewModelClass: Class<out ViewModel>) {
            factory.clear(viewModelClass)
        }

    }

    override fun onCreate() {
        super.onCreate()
        factory = ViewModelFactory.Base(ProvideViewModel.Base(clear))

    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
    }
}