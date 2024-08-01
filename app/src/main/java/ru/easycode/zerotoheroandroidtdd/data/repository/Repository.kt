package ru.easycode.zerotoheroandroidtdd.data.repository

import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.model.ItemCache

interface Repository {

    interface Read{
        fun list():List<String>
    }

    interface Add{
        fun add(value:String)
    }

    interface Mutable:Add,Read

    class Base(
        private val dataSource: ItemsDao,
        private val now: Now):Mutable{
        override fun list(): List<String> {
            return  dataSource.list().map {
                it.text.toString()
            }
        }

        override fun add(value: String) {
            dataSource.add(
                ItemCache(
                    id = now.nowMillis(),
                    text = value)
            )
        }

    }
}
