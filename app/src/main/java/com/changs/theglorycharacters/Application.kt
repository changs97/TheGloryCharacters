package com.changs.theglorycharacters

import android.app.Application
import android.content.Context
import timber.log.Timber

class Application : Application() {
    init{
        instance = this
    }

    companion object {
        lateinit var instance: Application
        fun getApplicationContext() : Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}