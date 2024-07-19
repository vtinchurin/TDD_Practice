package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun apply(button:Button, textView: TextView,progressBar: ProgressBar)


    object ShowProgress : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = false
            textView.isVisible = false
            progressBar.isVisible = true
        }

    }

    object ShowData : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            progressBar.isVisible = false
            button.isEnabled = true
            textView.isVisible = true
        }

    }

}
