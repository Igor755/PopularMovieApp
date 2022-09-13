package com.test.popularmovie.common

import android.app.Application
import com.test.popularmovie.di.adaptersModule
import com.test.popularmovie.di.interactorsModule
import com.test.popularmovie.di.viewModelsModule
import com.test.di.dataProvidersModule
import com.test.di.repositoriesModule
import com.test.di.sourcesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    sourcesModule,
                    dataProvidersModule,
                    adaptersModule,
                    viewModelsModule,
                    interactorsModule,
                    repositoriesModule
                )
            )
        }
    }
}