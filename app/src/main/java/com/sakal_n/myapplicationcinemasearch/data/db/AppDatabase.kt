package com.sakal_n.myapplicationcinemasearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sakal_n.myapplicationcinemasearch.data.dao.FilmDao
import com.sakal_n.myapplicationcinemasearch.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}
