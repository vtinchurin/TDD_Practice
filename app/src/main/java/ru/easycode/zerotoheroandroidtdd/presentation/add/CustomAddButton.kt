package ru.easycode.zerotoheroandroidtdd.presentation.add

import android.content.Context
import android.util.AttributeSet
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.button.AbstractMaterialButton


class CustomAddButton : AbstractMaterialButton, AddButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}


