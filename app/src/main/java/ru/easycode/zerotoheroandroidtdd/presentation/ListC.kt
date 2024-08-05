package ru.easycode.zerotoheroandroidtdd.presentation

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListC:ListLiveDataWrapper.Add {

    interface Add:ListC{
        override fun add(value:String)
    }

}
