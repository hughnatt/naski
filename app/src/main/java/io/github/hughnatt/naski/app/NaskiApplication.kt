package io.github.hughnatt.naski.app

import android.app.Application
import io.github.hughnatt.data.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NaskiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NaskiApplication)
            androidLogger()
            modules(
                appModule,
                databaseModule,
            )
        }
    }
}