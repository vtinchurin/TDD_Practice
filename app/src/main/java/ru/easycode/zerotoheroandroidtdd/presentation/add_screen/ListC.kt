package ru.easycode.zerotoheroandroidtdd.presentation.add_screen

import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.ListLiveDataWrapper

interface ListC : ListLiveDataWrapper.Add {

    interface Add : ListC {
        override fun add(value:String)
    }

}
