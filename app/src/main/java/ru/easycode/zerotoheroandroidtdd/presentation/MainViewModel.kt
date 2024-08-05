package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class MainViewModel(
    private val repository: Repository.Mutable,
    private val liveDataWrapper: ListLiveDataWrapper.Mutable,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main):ViewModel(),ListLiveDataWrapper.Read {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
        fun init(){
            viewModelScope.launch(dispatcher) {
                val list = repository.list()
                liveDataWrapper.update(list)
            }
        }

    override fun liveData(): LiveData<List<String>> =
        liveDataWrapper.liveData()

    fun clearDB(){
        viewModelScope.launch(dispatcher) {
            repository.clear()
        }

    }
}
