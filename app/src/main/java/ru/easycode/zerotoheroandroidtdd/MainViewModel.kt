package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineDispatcher
import ru.easycode.zerotoheroandroidtdd.data.ToUi
import ru.easycode.zerotoheroandroidtdd.domain.Repository

class MainViewModel(
    private val repository: Repository.Read,
    private val liveDataWrapper: ListLiveDataWrapper.All,
    private val dispatcher: CoroutineDispatcher,
    private val dispatcherMain: CoroutineDispatcher,
) {

    private val mapper = ToUi()

    fun init() {
        val items = repository.list().map {
            it.map(mapper)
        }
        liveDataWrapper.update(items)
    }

}
