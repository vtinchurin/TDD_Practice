package ru.easycode.zerotoheroandroidtdd.presentation.view.core

import java.io.Serializable

interface CustomViewUi : Serializable {
    fun <T : CustomView> update(button: T)
}