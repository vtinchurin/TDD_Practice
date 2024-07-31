package ru.easycode.zerotoheroandroidtdd.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListScreen

class MainViewModel(
    private val navigation: Navigation.Mutable
) : ViewModel(),Navigation.Read {

    fun init(firstRun: Boolean) {
        if (firstRun) navigation.update(ListScreen)
    }

    override fun liveData() = navigation.liveData()
}
