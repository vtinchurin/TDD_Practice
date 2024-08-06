package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.repository.Now
import ru.easycode.zerotoheroandroidtdd.data.repository.RepositoryImpl
import ru.easycode.zerotoheroandroidtdd.presentation.add_screen.AddViewModel
import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.MainViewModel

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(viewModelClass: Class<T>):T

    class Base(
        private val clear:ClearViewModel,
        dataSource: ItemsDao,
        now:Now,
    ):ProvideViewModel {

        private val repository = RepositoryImpl(dataSource,now)
        private val liveDataWrapper = ListLiveDataWrapper.Base()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when (viewModelClass){
                MainViewModel::class.java -> MainViewModel(
                    repository = repository,
                    liveDataWrapper = liveDataWrapper)

                AddViewModel::class.java -> AddViewModel(
                    repository = repository,
                    liveDataWrapper = liveDataWrapper,
                    clear = clear)
                else -> {
                    throw IllegalStateException("ERROR HERE!")
                }
            } as T
        }
    }
}