package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Update<T> {
        fun update(value: T)
    }


    interface Read<T : Any> {
        fun liveData(): LiveData<T>
    }

    interface All<T : Any> : Update<T>, Read<T>

    abstract class Abstract<T : Any>(
        protected val liveData: MutableLiveData<T> = MutableLiveData(),
    ) : All<T> {

        override fun update(value: T) {
            liveData.value = value
        }

        override fun liveData(): LiveData<T> {
            return liveData as LiveData<T>
        }
    }
}