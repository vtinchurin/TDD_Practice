package ru.easycode.zerotoheroandroidtdd.presentation.view.core

interface CustomView {

    fun update(state: CustomViewUi)

    interface UpdateVisibility : CustomView {
        fun update(visibility: Int)
    }

    interface UpdateDisabled : CustomView {
        fun update(isEnabled: Boolean)
    }

    interface UpdateText : CustomView {
        fun update(text: String)
    }

}
