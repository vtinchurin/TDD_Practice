package ru.easycode.zerotoheroandroidtdd.data


interface Read {
    fun list(): List<ItemCache>
}

interface Add {
    fun add(item: ItemCache)
}

interface Delete {
    fun delete(id: Long)
}

interface Items {
    fun item(id: Long): ItemCache
}

interface All : Read, Add, Delete, Items
interface ItemsDao : All {

    class Base : ItemsDao {

        private val list = mutableListOf<ItemCache>()

        override fun list(): List<ItemCache> {
            return list
        }

        override fun add(item: ItemCache) {
            list.add(item)
        }

        override fun delete(id: Long) {
            list.remove(item(id))
        }

        override fun item(id: Long): ItemCache {
            return list.find { it.id == id }!!
        }
    }
}