package com.sakal_n.myapplicationcinemasearch

import android.app.Application
import com.sakal_n.myapplicationcinemasearch.di.AppComponent
import com.sakal_n.myapplicationcinemasearch.di.modules.DatabaseModule
import com.sakal_n.myapplicationcinemasearch.di.modules.DomainModule
import com.sakal_n.myapplicationcinemasearch.di.modules.RemoteModule
import com.sakal_n.myapplicationcinemasearch.di.DaggerAppComponent


class App : Application() {
    lateinit var dagger: AppComponent


    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}


