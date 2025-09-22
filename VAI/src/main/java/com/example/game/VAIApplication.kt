package com.example.game

import android.app.Application
import com.example.game.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VAIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VAIApplication)
            modules(appModule)
        }
    }
}
