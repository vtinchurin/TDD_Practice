package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation


interface ProvideViewModel {

    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base : ProvideViewModel {
        private val navigation = Navigation.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when (viewModelClass){
                MainViewModel::class.java -> MainViewModel(navigation)
                CreateViewModel::class.java -> CreateViewModel(ListLiveDataWrapper.Base(),navigation)
                ListViewModel::class.java -> ListViewModel(ListLiveDataWrapper.Base(),navigation)
                else -> throw IllegalStateException("error")
            } as T
        }

    }
}
