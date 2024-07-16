package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isGone
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {
    private lateinit var layout: LinearLayout
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.rootLayout)

        textView = findViewById(R.id.titleTextView)
        val button: Button = findViewById(R.id.removeButton)


        button.setOnClickListener {
            layout.removeView(textView)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedTextView = layout.childCount == 1
        outState.putBoolean("qwe", removedTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean("qwe")
        if (removedTextView) {
            layout.removeView(textView)
        }
    }
}