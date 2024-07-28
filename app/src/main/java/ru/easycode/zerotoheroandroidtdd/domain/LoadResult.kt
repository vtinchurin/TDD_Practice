package ru.easycode.zerotoheroandroidtdd.domain

import ru.easycode.zerotoheroandroidtdd.presentation.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.UiState

interface LoadResult {

    fun show(updateLiveData:LiveDataWrapper.Update)

    data class Success(
        val data: SimpleResponse
    ) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }
    }

    data class Error(
        val noConnection:Boolean
    ):LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            when (noConnection){
                true -> updateLiveData.update(UiState.ShowData("No internet connection"))
                false -> updateLiveData.update(UiState.ShowData("Something went wrong"))
            }

        }
    }

}
