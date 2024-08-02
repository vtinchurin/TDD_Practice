package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.presentation.MainViewModel

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(viewModelClass: Class<out T>):T

    class Base():ProvideViewModel {

        override fun <T : ViewModel> viewModel(viewModelClass: Class<out T>): T {
            when (viewModelClass){
                MainViewModel::class.java -> MainViewModel(repository = )
            }
        }
    }
}