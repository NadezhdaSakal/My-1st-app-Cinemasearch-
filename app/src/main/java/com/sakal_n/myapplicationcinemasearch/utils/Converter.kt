package com.sakal_n.myapplicationcinemasearch.utils

import com.sakal_n.myapplicationcinemasearch.data.Entity.TmdbFilm
import com.sakal_n.myapplicationcinemasearch.domain.Film


object Converter {
    fun convertApiListToDTOList (list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }

}