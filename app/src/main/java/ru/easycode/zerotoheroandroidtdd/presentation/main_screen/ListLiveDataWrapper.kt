package ru.easycode.zerotoheroandroidtdd.presentation.main_screen

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Read : LiveDataWrapper.Read<List<String>>
    interface Update : LiveDataWrapper.Update<List<String>>
    interface Add {
        fun add(value: String)
    }

    interface All : Mutable, Add
    interface Mutable : Read, Update

    class Base : All, LiveDataWrapper.Abstract<List<String>>() {

        override fun add(value: String) {
            val list = liveData().value?.toMutableList() ?: ArrayList()
            list.add(value)
            update(list)
        }
    }
}