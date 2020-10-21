package com.anry200.thepokedex

import android.app.Application
import com.anry200.thepokedex.di.AppComponent
import com.anry200.thepokedex.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }
}