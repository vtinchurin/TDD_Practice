package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.SingleLiveEvent

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val liveData : MutableLiveData<UiState> = SingleLiveEvent()
    ): LiveDataWrapper {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData() = liveData
    }
}
