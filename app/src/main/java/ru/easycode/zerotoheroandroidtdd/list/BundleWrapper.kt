package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(value: ArrayList<CharSequence>)
    }

    interface Restore {
        fun restore(): List<CharSequence>
    }

    interface Mutable : Save, Restore

    class Base(
        private val bundle: Bundle
    ) : Mutable {
        override fun save(value: ArrayList<CharSequence>) {
            bundle.putCharSequenceArrayList(KEY, value)
        }

        override fun restore(): List<CharSequence> {
            return bundle.getCharSequenceArrayList(KEY) ?: listOf()
        }

        companion object {
            private const val KEY = "listKey"
        }
    }
}
