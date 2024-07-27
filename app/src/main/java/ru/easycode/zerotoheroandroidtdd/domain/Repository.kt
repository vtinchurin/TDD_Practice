package ru.easycode.zerotoheroandroidtdd.domain

import ru.easycode.zerotoheroandroidtdd.data.SimpleService

interface Repository {

    suspend fun load(): SimpleResponse

    class Base(
        val service: SimpleService,
        val url: String,
        ): Repository {
        override suspend fun load(): SimpleResponse {
            //delay(3000)
            return service.fetch(url)
        }
    }
}
