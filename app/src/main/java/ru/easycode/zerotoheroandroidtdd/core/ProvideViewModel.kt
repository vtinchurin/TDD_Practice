package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation


interface ProvideViewModel {

    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base(
        private val navigation: Navigation.Mutable,
        private val clearViewModel: ClearViewModel,
    ) : ProvideViewModel {
        //private val navigation = Navigation.Base()
        private val listDataWrapper = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            Log.e("logging", "Base ProvideVM fun ")
            return when (viewModelClass){
                MainViewModel::class.java -> MainViewModel(navigation)
                CreateViewModel::class.java -> CreateViewModel(listDataWrapper,navigation,clearViewModel)
                ListViewModel::class.java -> ListViewModel(listDataWrapper,navigation)
                else -> throw IllegalStateException("error")
            } as T
        }



    }
}
