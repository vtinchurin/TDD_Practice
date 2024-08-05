package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.fragment.app.FragmentManager

object AddScreen:Screen {
    override fun show(supportFragmentManager: FragmentManager) {
        AddButtonSheetFragment().show(supportFragmentManager,"")
    }
}