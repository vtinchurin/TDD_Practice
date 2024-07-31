package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.App
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ProvideViewModel {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("logging", "MA on Create")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = viewModel(MainViewModel::class.java)

        viewModel.liveData().observe(this){
            Log.e("logging", "Screen changed in observable")
            it.show(supportFragmentManager,binding.container.id)
        }
        viewModel.init(savedInstanceState==null)
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        Log.e("logging", "MA vm as ProvideVMe")
        return (application as App).viewModel(viewModelClass)
    }


}