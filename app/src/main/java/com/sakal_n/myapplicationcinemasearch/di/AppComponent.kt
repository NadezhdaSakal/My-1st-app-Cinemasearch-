package com.sakal_n.myapplicationcinemasearch.di

import com.sakal_n.myapplicationcinemasearch.di.modules.DatabaseModule
import com.sakal_n.myapplicationcinemasearch.di.modules.DomainModule
import com.sakal_n.myapplicationcinemasearch.di.modules.RemoteModule
import com.sakal_n.myapplicationcinemasearch.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}