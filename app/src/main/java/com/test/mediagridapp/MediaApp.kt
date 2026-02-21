package com.test.mediagridapp

import android.app.Application
import com.test.mediagridapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MediaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MediaApp)
            modules(appModule)
        }
    }
}