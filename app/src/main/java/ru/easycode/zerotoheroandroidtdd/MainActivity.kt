package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var arrayList: ArrayList<String>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("qwe", "Create")
        arrayList = ArrayList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val textView = TextView(this)
            textView.text = binding.inputEditText.text.toString()
            binding.contentLayout.addView(textView)
            arrayList.add(binding.inputEditText.text.toString())
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("qwe", "SaveInstance")
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("list", arrayList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        arrayList = savedInstanceState.getStringArrayList("list") as ArrayList<String>
        for (i in arrayList) {
            val tv = TextView(this)
            tv.text = i
            binding.contentLayout.addView(tv)
        }
    }

}