package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class AddViewModel(
    private val repository: Repository.Add,
    private val liveDataWrapper: ListLiveDataWrapper.Add,
    private val clear: ClearViewModel,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main
):ViewModel() {
    private val viewModelScope  = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    fun add(value:String){
        viewModelScope.launch (dispatcher){
            repository.add(value)
            liveDataWrapper.add(value)
            comeback()
        }

    }

    fun comeback(){
        clear.clearViewModel(this::class.java)
    }
}
