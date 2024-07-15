package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.changeButton)
        textView = findViewById<TextView>(R.id.titleTextView)

        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }

        fun onSaveInstanceState(outState:Bundle){
            super.onSaveInstanceState(outState)
            outState.putString("key",textView.text.toString())
        }

        fun onRestoreInstanceState(savedInstanceState:Bundle){
            super.onRestoreInstanceState(savedInstanceState)
            textView.text = savedInstanceState.getString("key")
        }

    }
}