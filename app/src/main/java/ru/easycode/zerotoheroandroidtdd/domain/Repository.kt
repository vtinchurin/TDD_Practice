package ru.easycode.zerotoheroandroidtdd.domain

import ru.easycode.zerotoheroandroidtdd.data.SimpleService
import java.io.IOException

interface Repository {

    suspend fun load():LoadResult

    class Base(
        private val service:SimpleService,
        private val url:String,
    ):Repository {
        override suspend fun load(): LoadResult {
            try {
                val response = service.fetch(url)
                return LoadResult.Success(data = response)
            }catch (e:IOException){
                return LoadResult.Error(true)
            }catch (e:Exception){
                return LoadResult.Error(false)
            }

        }
    }

}
