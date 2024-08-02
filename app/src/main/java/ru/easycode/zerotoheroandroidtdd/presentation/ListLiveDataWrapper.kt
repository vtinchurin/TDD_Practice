package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Read : LiveDataWrapper.Read<List<String>>
    interface Update : LiveDataWrapper.Update<List<String>>
    interface Mutable : Read, Update

    class Base : Mutable, LiveDataWrapper.Abstract<List<String>>()
}

