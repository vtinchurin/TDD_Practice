package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class MainViewModel(
    private val repository: Repository.Read,
    private val liveDataWrapper: ListLiveDataWrapper.Mutable,
    private val dispatcher: CoroutineDispatcher,
    private val dispatcherMain: CoroutineDispatcher):ViewModel() {


        fun init(){
            val list = repository.list()
            liveDataWrapper.update(list)
        }
}
