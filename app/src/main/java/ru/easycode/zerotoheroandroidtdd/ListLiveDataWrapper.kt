package ru.easycode.zerotoheroandroidtdd

interface ListLiveDataWrapper {

    interface Add<T : Any> {
        fun add(value: T)
    }

    interface Update : LiveDataWrapper.Update<List<ItemUi>>

    interface Delete<T : Any> {
        fun delete(item: T)
    }

    interface Read : LiveDataWrapper.Read<List<ItemUi>>


    interface All : Update, Read, Add<ItemUi>, Delete<ItemUi>


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

interface ItemUi