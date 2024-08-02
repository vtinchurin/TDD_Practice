package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory:ProvideViewModel {

    class Base(
        private val provide:ProvideViewModel,
    ):ViewModelFactory {

        private val cache : MutableMap<Class<out ViewModel>,ViewModel> = mutableMapOf()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<out T>): T {
            if (cache.containsKey(viewModelClass)) {
                return cache[viewModelClass]
            }else return provide.viewModel(viewModelClass)
        }
    }
}