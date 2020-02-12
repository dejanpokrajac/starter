package com.sample.starter

import android.app.Application
import com.sample.starter.di.appComponent
import org.koin.android.ext.android.startKoin

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    open fun configureDi() =
        startKoin(this, provideComponent())

    open fun provideComponent() = appComponent
}