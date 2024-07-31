package ru.easycode.zerotoheroandroidtdd.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class ListViewModel(
    private val liveDataWrapper: ListLiveDataWrapper.Mutable,
    private val navigation: Navigation.Update,
) : ViewModel(), ListLiveDataWrapper.Read {

    fun create() {
        navigation.update(CreateScreen)
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val restored = bundleWrapper.restore()
        liveDataWrapper.update(restored)
    }

    override fun liveData() = liveDataWrapper.liveData()

}
