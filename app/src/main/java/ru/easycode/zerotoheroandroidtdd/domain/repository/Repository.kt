package ru.easycode.zerotoheroandroidtdd.domain.repository

interface Repository {

    interface Read{
        fun list():List<String>
    }

    interface Add{
        fun add(value:String)
    }


    interface Mutable : Add, Read

}