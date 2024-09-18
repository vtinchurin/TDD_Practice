package ru.easycode.zerotoheroandroidtdd

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.easycode.zerotoheroandroidtdd.data.Base
import ru.easycode.zerotoheroandroidtdd.data.ItemCache
import ru.easycode.zerotoheroandroidtdd.data.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.Now
import ru.easycode.zerotoheroandroidtdd.domain.Item
import ru.easycode.zerotoheroandroidtdd.domain.ItemDomain
import ru.easycode.zerotoheroandroidtdd.domain.Repository

class RepositoryTest {

    private lateinit var now: FakeNow
    private lateinit var dataSource: FakeDataSource
    private lateinit var repository: Repository.All

    @Before
    fun setup() {
        now = FakeNow.Base(7777L)
        dataSource = FakeDataSource.Base()
        repository = Base(dataSource = dataSource, now = now)
    }

    @Test
    fun test_add() {
        dataSource.expectList(
            listOf(
                ItemCache(id = 0L, text = "first"),
                ItemCache(id = 1L, text = "second")
            )
        )

        val actual: List<Item> = repository.list()
        val expected = listOf(ItemDomain(0, "first"), ItemDomain(1, "second"))
        assertEquals(expected, actual)

        repository.add(value = "third")
        dataSource.checkList(
            listOf(
                ItemCache(id = 0L, text = "first"),
                ItemCache(id = 1L, text = "second"),
                ItemCache(id = 7778L, text = "third")
            )
        )
    }

    @Test
    fun test_item() {
        repository.add(value = "first")
        dataSource.checkList(listOf(ItemCache(id = 7778L, text = "first")))

        val actual: Item = repository.item(id = 7778L)
        val expected = ItemDomain(id = 7778L, text = "first")
        assertEquals(expected, actual)
    }

    @Test
    fun test_delete() {
        repository.add("first")
        dataSource.checkList(listOf(ItemCache(id = 7778L, text = "first")))

        repository.add(value = "second")
        dataSource.checkList(
            listOf(
                ItemCache(id = 7778L, text = "first"),
                ItemCache(7779L, text = "second")
            )
        )

        repository.delete(id = 7778L)
        dataSource.checkList(listOf(ItemCache(7779L, text = "second")))
    }
}

private interface FakeNow : Now {

    class Base(private var value: Long) : FakeNow {

        override fun nowMillis(): Long {
            return ++value
        }
    }
}

private interface FakeDataSource : ItemsDao {

    fun checkList(expected: List<ItemCache>)

    fun expectList(list: List<ItemCache>)

    class Base : FakeDataSource {

        private val list = mutableListOf<ItemCache>()

        override fun checkList(expected: List<ItemCache>) {
            assertEquals(expected, list)
        }

        override fun expectList(list: List<ItemCache>) {
            this.list.addAll(list)
        }

        override fun list(): List<ItemCache> {
            return list
        }

        override fun add(item: ItemCache) {
            list.add(item)
        }

        override fun item(id: Long): ItemCache {
            return list.find { it.id == id }!!
        }

        override fun delete(id: Long) {
            list.remove(item(id))
        }
    }
}