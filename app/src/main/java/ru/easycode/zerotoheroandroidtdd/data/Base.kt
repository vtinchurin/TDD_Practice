package ru.easycode.zerotoheroandroidtdd.data


import ru.easycode.zerotoheroandroidtdd.domain.Item
import ru.easycode.zerotoheroandroidtdd.domain.Repository

class Base(
    private val dataSource: ItemsDao,
    private val now: Now,
) : Repository.All {


    override fun item(id: Long): Item {
        val item = dataSource.item(id)
        return Item(item.id, item.text)

    }

    override fun list(): List<Item> {
        val newList = dataSource.list().map {
            Item(it.id, it.text)
        }
        return newList
    }

    override fun add(value: String) {
        val id = now.nowMillis()
        dataSource.add(item = ItemCache(id, value))
    }

    override fun delete(id: Long) {
        dataSource.delete(id)
    }
}

