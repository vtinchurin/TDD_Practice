package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class AddViewModel(
    private val repository: Repository.Add,
    private val liveDataWrapper: ListC.Add,
    private val clear: ClearViewModel,
    private val dispatcher: CoroutineDispatcher,
    private val dispatcherMain: CoroutineDispatcher
):ViewModel() {
    private val viewModelScope  = CoroutineScope(SupervisorJob() + dispatcher)
    fun add(value:String){
        viewModelScope.launch {
            repository.add(value)
            liveDataWrapper.add(value)
        }
        comeback()
    }

    fun comeback(){
        clear.clearViewModel(AddViewModel::class.java)
    }
}
