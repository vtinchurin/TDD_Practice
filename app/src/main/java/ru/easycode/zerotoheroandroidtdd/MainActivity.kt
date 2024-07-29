package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.inputEditText.doAfterTextChanged {
            bindings.actionButton.isEnabled = it.toString().length >= 3
        }

        bindings.actionButton.setOnClickListener {
            bindings.titleTextView.text = bindings.inputEditText.text
            bindings.inputEditText.setText("")
        }
    }
}