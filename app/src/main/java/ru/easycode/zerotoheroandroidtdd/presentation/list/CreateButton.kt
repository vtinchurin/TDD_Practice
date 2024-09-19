package ru.easycode.zerotoheroandroidtdd.presentation.list

import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomView
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomViewUi

interface CreateButton : CustomView.UpdateDisabled {

    object Default : CustomViewUi {
        override fun <T : CustomView> update(button: T) = Unit
    }


}