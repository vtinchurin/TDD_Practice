package ru.easycode.zerotoheroandroidtdd.presentation.core

import ru.easycode.zerotoheroandroidtdd.presentation.AddScreen


interface Navigation : NavigateToAdd, NavigateToDelete, NavigateToList {

    fun navigate(screen: Screen)

    override fun navigateToAdd() = navigate(AddScreen)
    override fun navigateToDelete() = navigate(DeleteScreen)
    override fun navigateToList() = navigate(ListScreen)
}

interface NavigateToAdd {
    fun navigateToAdd()
}

interface NavigateToDelete {
    fun navigateToDelete()
}

interface NavigateToList {
    fun navigateToList()
}