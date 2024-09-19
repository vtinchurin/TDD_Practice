package ru.easycode.zerotoheroandroidtdd.presentation.delete

import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomView
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomViewUi

interface DeleteButton : CustomView.UpdateDisabled {

    object Default : CustomViewUi {
        override fun <T : CustomView> update(button: T) = Unit
    }

}