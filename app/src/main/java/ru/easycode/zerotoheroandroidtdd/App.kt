package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.easycode.zerotoheroandroidtdd.data.SimpleService
import ru.easycode.zerotoheroandroidtdd.domain.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.presentation.MainViewModel

class App:Application() {
    lateinit var viewModel: MainViewModel
    private val URL = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: SimpleService = retrofit.create(SimpleService::class.java)
        viewModel = MainViewModel(
            Repository.Base(service,URL),
            LiveDataWrapper.Base())
    }
}