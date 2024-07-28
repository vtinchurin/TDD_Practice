package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.SingleLiveEvent

interface LiveDataWrapper {

    interface Update:LiveDataWrapper{
        fun update(value: UiState)
    }

    interface Save:LiveDataWrapper{
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Observable:LiveDataWrapper{
        fun liveData(): LiveData<UiState>
    }

    interface Mutable:Save,Update,Observable




    class Base(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ):Mutable {
        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}

