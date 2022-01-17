package com.sakal_n.myapplicationcinemasearch.di


import com.sakal_n.myapplicationcinemasearch.viewmodel.HomeFragmentViewModel
import com.sakal_n.myapplicationcinemasearch.di.module.DatabaseModule
import com.sakal_n.myapplicationcinemasearch.di.module.DomainModule
import com.sakal_n.myapplicationcinemasearch.di.module.RemoteModule
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