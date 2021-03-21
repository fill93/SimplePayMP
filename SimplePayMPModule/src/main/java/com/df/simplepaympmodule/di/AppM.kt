package com.df.simplepaympmodule.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppM : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@AppM)
            koin.loadModules(
                listOf(
                    apisModule,
                    repositoryesModule,
                    viewModelsModule
                )
            )
            koin.createRootScope()
        }
    }
}