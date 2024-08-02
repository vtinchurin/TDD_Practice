package ru.easycode.zerotoheroandroidtdd.presentation

import kotlinx.coroutines.CoroutineDispatcher
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class AddViewModel(
    private val repository: Repository.Add,
    private val liveDataWrapper: ListC.Add,
    private val clear: FakeClearViewModel.Base,
    private val dispatcher: CoroutineDispatcher,
    private val dispatcherMain: CoroutineDispatcher
) {

    fun add(value:String){
        repository.add(value)
    }

    fun comeback(){

    }
}
