package ru.easycode.zerotoheroandroidtdd.domain.repository

interface Repository {

    interface Read{
        fun list():List<String>
    }

    interface Add{
        fun add(value:String)
    }

    interface Clear{
        fun clear()
    }

    interface Mutable:Add,Read,Clear

}