package ru.easycode.zerotoheroandroidtdd.list

import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Update : LiveDataWrapper.Update<List<CharSequence>>

    interface Read : LiveDataWrapper.Read<List<CharSequence>>

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Add {
        fun add(source: CharSequence)
    }

    interface Mutable : Update, Read, Save

    interface All : Mutable, Add

    class Base : All, LiveDataWrapper.Abstract<List<CharSequence>>() {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(ArrayList(it)) }
        }

        override fun add(source: CharSequence) {
            val currentList = liveData.value ?: ArrayList()
            val newList = ArrayList<CharSequence>(currentList)
            newList.add(source)
            liveData.value = newList
        }

    }
}
