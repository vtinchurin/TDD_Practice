package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = (application as App).viewModel
        val button:Button = findViewById(R.id.actionButton)
        val textView:TextView = findViewById(R.id.titleTextView)
        val progressBar:ProgressBar = findViewById(R.id.progressBar)

        button.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this){
            it.apply(button, textView, progressBar)
        }
    }
}