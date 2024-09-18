package ru.easycode.zerotoheroandroidtdd.domain


interface Repository {

    interface Read {
        fun list(): List<Item>
    }

    interface Add {
        fun add(value: String)
    }

    interface Delete {
        fun delete(id: Long)
    }

    interface Items {
        fun item(id: Long): Item
    }

    interface All : Read, Add, Delete, Items
}
