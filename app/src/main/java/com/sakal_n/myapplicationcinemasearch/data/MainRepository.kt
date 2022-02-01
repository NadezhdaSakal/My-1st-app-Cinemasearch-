package com.sakal_n.myapplicationcinemasearch.data

//import androidx.lifecycle.LiveData
import com.sakal_n.myapplicationcinemasearch.data.dao.FilmDao
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import java.util.concurrent.Executors
import kotlinx.coroutines.flow.Flow



class MainRepository(private val filmDao: FilmDao) {


    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)


    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}


