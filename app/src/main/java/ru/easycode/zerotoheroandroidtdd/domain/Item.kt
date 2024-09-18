package ru.easycode.zerotoheroandroidtdd.domain

import ru.easycode.zerotoheroandroidtdd.domain.Item.Mapper


interface Item {

    fun <T : Item> map(mapper: Mapper<T>): T


    interface Mapper<T : Item> {

        fun map(id: Long, text: String): T

        class ToDomain : Mapper<ItemDomain> {
            override fun map(id: Long, text: String): ItemDomain {
                return ItemDomain(id, text)
            }
        }
    }
}

data class ItemDomain(
    private val id: Long,
    private val text: String,
) : Item {

    override fun <T : Item> map(mapper: Mapper<T>): T {
        return mapper.map(id, text)
    }
}