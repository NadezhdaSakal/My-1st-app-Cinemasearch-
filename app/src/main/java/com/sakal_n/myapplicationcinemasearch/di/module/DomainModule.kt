package com.sakal_n.myapplicationcinemasearch.di.module

import com.sakal_n.myapplicationcinemasearch.data.MainRepository
import com.sakal_n.myapplicationcinemasearch.data.TmdbApi
import com.sakal_n.myapplicationcinemasearch.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}
