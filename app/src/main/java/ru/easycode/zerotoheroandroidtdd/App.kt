package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import ru.easycode.zerotoheroandroidtdd.core.Core

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val core = Core.Base(applicationContext)

    }
}