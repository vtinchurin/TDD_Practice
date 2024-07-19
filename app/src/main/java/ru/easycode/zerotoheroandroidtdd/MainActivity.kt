package ru.easycode.zerotoheroandroidtdd

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    private fun delay(time:Long, block:()->Unit){
        lifecycleScope.launch {
            delay(time)
            block()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val textView:TextView = findViewById(R.id.titleTextView)
        val button:Button = findViewById(R.id.actionButton)

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            button.postDelayed({
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
                button.isEnabled = true
            },2000)
        }

    }
}