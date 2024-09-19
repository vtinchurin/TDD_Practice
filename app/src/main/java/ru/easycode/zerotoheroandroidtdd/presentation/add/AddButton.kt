package ru.easycode.zerotoheroandroidtdd.presentation.add

import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomView
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.CustomViewUi

interface AddButton : CustomView.UpdateDisabled {

    abstract class AddButtonUi<K : AddButton>(
        private val isEnabled: Boolean,
    ) : CustomViewUi {
        override fun <T : CustomView> update(button: T) {
            (button as K).update(isEnabled)
        }
    }

    object Enabled : AddButtonUi<AddButton>(true)
    object Disabled : AddButtonUi<AddButton>(false)
}