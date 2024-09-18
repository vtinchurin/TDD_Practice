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

}