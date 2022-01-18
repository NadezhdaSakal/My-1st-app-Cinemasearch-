package com.sakal_n.myapplicationcinemasearch.data


import com.sakal_n.myapplicationcinemasearch.data.dao.FilmDao
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import java.util.concurrent.Executors


class MainRepository(private val filmDao: FilmDao) {


    fun putToDb(films: List<Film>) {
        //Запросы в бд должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }

    }

    fun getAllFromDB(): List<Film> {
        return filmDao.getCachedFilms()

    }


}