package ru.easycode.zerotoheroandroidtdd.presentation.add_screen

import androidx.fragment.app.FragmentManager
import ru.easycode.zerotoheroandroidtdd.presentation.Screen

object AddScreen : Screen {
    override fun show(supportFragmentManager: FragmentManager) {
        AddButtonSheetFragment().show(supportFragmentManager,"")
    }
}