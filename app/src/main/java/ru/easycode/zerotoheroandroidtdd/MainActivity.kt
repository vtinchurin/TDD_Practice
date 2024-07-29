package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var arrayList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("qwe","Create")
        super.onCreate(savedInstanceState)
        val bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        arrayList = if (savedInstanceState != null) {
            savedInstanceState.getStringArrayList("list") as ArrayList<String>
        }else arrayListOf()
        for (i in arrayList){
            val tv = TextView(this)
            tv.text = i
            bindings.contentLayout.addView(tv)
        }



        bindings.actionButton.setOnClickListener {
            val textView = TextView(this)
            textView.text = bindings.inputEditText.text.toString()
            bindings.contentLayout.addView(textView)
            arrayList.add(textView.text.toString())
            bindings.inputEditText.setText("")
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("qwe","SaveInstance")
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("list",arrayList)
    }


}