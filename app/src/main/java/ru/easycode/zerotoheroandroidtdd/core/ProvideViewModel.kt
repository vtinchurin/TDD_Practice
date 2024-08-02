package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.MainViewModel

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(viewModelClass: Class<T>):T

    class Base(
        private val repository: Repository.Mutable,
    ):ProvideViewModel {
        private val liveDataWrapper = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when (viewModelClass){
                MainViewModel::class.java -> MainViewModel(
                    repository = repository,
                    liveDataWrapper = liveDataWrapper,
                    dispatcher = Dispatchers.IO,
                    dispatcherMain = Dispatchers.Main)

                else -> {
                    throw IllegalStateException()
                }
            } as T
        }
    }
}