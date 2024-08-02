package ru.easycode.zerotoheroandroidtdd.presentation

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListC {

    interface Add:LiveDataWrapper.Add<String>

    class Base:Add {
        override fun add(value: String) {
            TODO("Not yet implemented")
        }
    }
}
