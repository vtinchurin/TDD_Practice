package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.domain.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.UiState

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {

    init {
        liveDataWrapper.update(UiState.InitialState)
    }
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            val result = repository.load()
            liveDataWrapper.update(UiState.ShowData(result.text))
        }

    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }
    
    
}
