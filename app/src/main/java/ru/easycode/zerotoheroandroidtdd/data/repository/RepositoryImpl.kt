package ru.easycode.zerotoheroandroidtdd.data.repository

import android.text.format.Time
import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.model.ItemCache
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository
import kotlin.random.Random


class RepositoryImpl(
    private val localDataSource: ItemsDao,
) : Repository.Mutable,Now {
    override fun list(): List<String> {
        return localDataSource.list().map {
            it.text.toString()
        }
    }

    override fun add(value: String) {
        localDataSource.add(
            ItemCache(
                id = nowMillis(),
                text = value
            )
        )
    }

    override fun nowMillis(): Long {
        return Random.nextLong()
    }

}

