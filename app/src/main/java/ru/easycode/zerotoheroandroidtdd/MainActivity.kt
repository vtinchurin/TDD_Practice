package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.hideButton)
        textView = findViewById<TextView>(R.id.titleTextView)
        button.setOnClickListener {
            textView.isVisible = !textView.isVisible
            button.text = when (textView.isVisible){
                true ->  "hide"
                false -> "open"
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("key", textView.isVisible)
        outState.putString("button",button.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.isVisible = savedInstanceState.getBoolean("key")
        button.text = savedInstanceState.getString("button")
    }

}