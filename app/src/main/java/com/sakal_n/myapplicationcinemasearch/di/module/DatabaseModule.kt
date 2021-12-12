package com.sakal_n.myapplicationcinemasearch.di.module


import com.sakal_n.myapplicationcinemasearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}
