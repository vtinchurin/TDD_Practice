package ru.easycode.zerotoheroandroidtdd.data


import ru.easycode.zerotoheroandroidtdd.domain.Item
import ru.easycode.zerotoheroandroidtdd.domain.Repository

class Base(
    private val dataSource: ItemsDao,
    private val now: Now,
) : Repository.All {

    private val mapper = Item.Mapper.ToDomain()

    override fun item(id: Long): Item {
        val item = dataSource.item(id)
        return item.map(mapper)

    }

    override fun list(): List<Item> {
        val newList = dataSource.list().map {
            it.map(mapper)
        }
        return newList
    }

    override fun add(value: String): Long {
        val id = now.nowMillis()
        dataSource.add(item = ItemCache(id, value))
        return id
    }

    override fun delete(id: Long) {
        dataSource.delete(id)
    }

}

