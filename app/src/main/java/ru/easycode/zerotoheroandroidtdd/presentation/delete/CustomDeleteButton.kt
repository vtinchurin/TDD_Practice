package ru.easycode.zerotoheroandroidtdd.presentation.delete

import android.content.Context
import android.util.AttributeSet
import ru.easycode.zerotoheroandroidtdd.presentation.view.core.button.AbstractMaterialButton

class CustomDeleteButton : AbstractMaterialButton, DeleteButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}