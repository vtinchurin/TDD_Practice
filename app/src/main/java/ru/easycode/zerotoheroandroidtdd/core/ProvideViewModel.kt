package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.repository.Now
import ru.easycode.zerotoheroandroidtdd.data.repository.RepositoryImpl
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.AddViewModel
import ru.easycode.zerotoheroandroidtdd.presentation.ListC
import ru.easycode.zerotoheroandroidtdd.presentation.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.MainViewModel
import javax.sql.DataSource

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
                    liveDataWrapper = liveDataWrapper,)
                    //dispatcher = Dispatchers.IO,
                    //dispatcherMain = Dispatchers.Main)
                AddViewModel::class.java -> AddViewModel(
                    repository = repository,
                    liveDataWrapper = liveDataWrapper,
                    clear = clear,
//                    dispatcher = Dispatchers.IO,
//                    dispatcherMain = Dispatchers.Main
                )
                else -> {
                    throw IllegalStateException()
                }
            } as T
        }
    }
}