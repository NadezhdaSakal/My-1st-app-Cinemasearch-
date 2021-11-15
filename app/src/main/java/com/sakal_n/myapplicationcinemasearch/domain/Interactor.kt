package com.sakal_n.myapplicationcinemasearch.domain

import com.sakal_n.myapplicationcinemasearch.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}

