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
    private val navigation = Navigation.Base()
    private val clear : ClearViewModel = object : ClearViewModel{
        override fun clear(viewModelClass: Class<out ViewModel>) {
            factory.clear(viewModelClass)
        }

    }

    override fun onCreate() {
        Log.e("logging", "App on Create")
        super.onCreate()
        factory = ViewModelFactory.Base(ProvideViewModel.Base(navigation,clear))

    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        Log.e("logging", "App vm as ProvideVM")
        return factory.viewModel(viewModelClass)
    }
}