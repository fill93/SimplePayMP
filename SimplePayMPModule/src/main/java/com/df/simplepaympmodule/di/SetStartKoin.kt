package com.df.simplepaympmodule.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object SetStartKoin {
    fun setKoin(context: Context) {
        startKoin{
            androidLogger()
            androidContext(context)
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