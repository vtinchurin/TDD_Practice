package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Update<T : Any> {
        fun update(value: T)
    }

    interface Read<T : Any> {
        fun liveData(): LiveData<T>
    }

    interface Mutable<T : Any> : Read<T>, Update<T>

    abstract class Abstract<T : Any>(
        private val liveData: MutableLiveData<T> = MutableLiveData(),
    ) : Mutable<T> {

        override fun liveData(): LiveData<T> {
            return liveData
        }

        override fun update(value: T) {
            liveData.postValue(value)
        }

    }
}