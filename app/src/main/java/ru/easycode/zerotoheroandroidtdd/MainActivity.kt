package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.presentation.add_screen.AddScreen
import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.Adapter
import ru.easycode.zerotoheroandroidtdd.presentation.main_screen.MainViewModel

class MainActivity : AppCompatActivity(),ProvideViewModel {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = viewModel(MainViewModel::class.java)

        setContentView(binding.root)

        val adapter = Adapter()

        binding.recyclerView.adapter = adapter

        viewModel.liveData().observe(this){
            adapter.update(it)
        }
        binding.addButton.setOnClickListener {
            AddScreen.show(supportFragmentManager)
        }

        viewModel.init()
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return (application as ProvideViewModel).viewModel(viewModelClass)
    }

    override fun onPause() {
        super.onPause()
        //viewModel.clearDB()
    }

}