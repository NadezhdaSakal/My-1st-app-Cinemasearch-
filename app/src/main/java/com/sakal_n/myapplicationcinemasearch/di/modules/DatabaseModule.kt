package com.sakal_n.myapplicationcinemasearch.di.modules

import android.content.Context
import com.sakal_n.myapplicationcinemasearch.data.MainRepository
import com.sakal_n.myapplicationcinemasearch.data.db.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)
    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}
