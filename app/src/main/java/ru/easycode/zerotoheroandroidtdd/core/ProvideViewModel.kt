package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(viewModelClass: Class<out T>):T

    class Base():ProvideViewModel {

        private val map = mutableMapOf<Class<out ViewModel>,ViewModel>()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<out T>): T {
            return  map[viewModelClass]
        }
    }
}