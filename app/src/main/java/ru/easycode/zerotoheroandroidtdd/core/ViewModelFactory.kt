package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory:ProvideViewModel {

    class Base(
        private val provide:ProvideViewModel,
    ):ViewModelFactory {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<out T>): T {
            return provide.viewModel(viewModelClass)
        }
    }
}