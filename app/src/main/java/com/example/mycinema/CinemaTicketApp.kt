package com.example.mycinema

import android.app.Application
import com.example.mycinema.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CinemaTicketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CinemaTicketApp)
            modules(appModule)
        }
    }
}
