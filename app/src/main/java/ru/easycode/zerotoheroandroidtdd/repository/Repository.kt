package ru.easycode.zerotoheroandroidtdd.repository

import kotlinx.coroutines.delay

interface Repository {

    suspend fun load()

    class Base : Repository {
        override suspend fun load() {
            delay(3000)
        }

    }
}
