package ru.easycode.zerotoheroandroidtdd.presentation.add_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.ListLiveDataWrapper

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
