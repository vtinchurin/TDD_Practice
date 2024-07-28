package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.domain.LoadResult
import ru.easycode.zerotoheroandroidtdd.domain.Repository

class MainViewModel(
    private val repository: Repository,
    private val liveDataWrapper: LiveDataWrapper.Mutable
) : LiveDataWrapper.Observable {
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load() {
        viewModelScope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            val result = repository.load()
            result.show(liveDataWrapper)
        }

    }


    override fun liveData(): LiveData<UiState> =
        liveDataWrapper.liveData()

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }

}
