package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.domain.Item

interface ListLiveDataWrapper {

    interface Add {
        fun add(value: ItemUi)
    }

    interface Update : LiveDataWrapper.Update<List<ItemUi>>

    interface Delete<T : Any> {
        fun delete(item: T)
    }

    interface Read : LiveDataWrapper.Read<List<ItemUi>>


    interface All : Update, Read, Add, Delete<ItemUi>


    class Base : All, LiveDataWrapper.Abstract<List<ItemUi>>() {

        override fun add(value: ItemUi) {
            val tmp: MutableList<ItemUi> = liveData.value!!.toMutableList()
            tmp.add(value)
            liveData.value = tmp
        }

        override fun delete(item: ItemUi) {
            val tmp: MutableList<ItemUi> = liveData.value!!.toMutableList()
            tmp.remove(item)
            liveData.value = tmp
        }
    }


}

data class ItemUi(
    private val id: Long,
    private val text: String,
) : Item {

    override fun <T : Item> map(mapper: Item.Mapper<T>): T {
        return mapper.map(id, text)
    }
}