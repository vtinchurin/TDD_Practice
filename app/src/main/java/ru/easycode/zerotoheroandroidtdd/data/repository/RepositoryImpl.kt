package ru.easycode.zerotoheroandroidtdd.data.repository

import ru.easycode.zerotoheroandroidtdd.data.dao.ItemsDao
import ru.easycode.zerotoheroandroidtdd.data.model.ItemCache
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository


class RepositoryImpl(
    private val localDataSource: ItemsDao,
    private val now: Now
) : Repository.Mutable {
    override fun list(): List<String> {
        return localDataSource.list().map {
            it.text.toString()
        }
    }

    override fun add(value: String) {
        localDataSource.add(
            ItemCache(
                id = now.nowMillis(),
                text = value
            )
        )
    }

}

