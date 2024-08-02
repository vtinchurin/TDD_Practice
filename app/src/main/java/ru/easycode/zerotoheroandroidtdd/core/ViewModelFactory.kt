package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory:ProvideViewModel,ClearViewModel {

    class Base(
        private val provideViewModel:ProvideViewModel,
    ):ViewModelFactory {

        private val cache: MutableMap<Class<out ViewModel>, ViewModel> = mutableMapOf()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            if (cache.containsKey(viewModelClass)) {
                return cache[viewModelClass] as T
            }else {
                val vm = provideViewModel.viewModel(viewModelClass)
                cache[viewModelClass] = vm
                return vm
            }
        }

        override fun clearViewModel(clasz: Class<out ViewModel>) {
            cache.remove(clasz)
        }
    }
}

