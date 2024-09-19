package ru.easycode.zerotoheroandroidtdd.presentation.list

import android.content.Context
import android.util.AttributeSet
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.button.AbstractMaterialButton

class CustomCreateButton : AbstractMaterialButton, CreateButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}