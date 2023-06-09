package com.changs.theglorycharacters

import android.app.Application
import android.content.Context
import timber.log.Timber

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}