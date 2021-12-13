package com.sakal_n.myapplicationcinemasearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sakal_n.myapplicationcinemasearch.domain.Film


class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setFilmsDetails()
    }

    private fun setFilmsDetails(detaiils_title: Any, details_poster: Any, details_description: Any) {
        //Получаем наш фильм из переданного бандла
        val film = intent.extras?.get("film") as Film

        //Устанавливаем заголовок
        detaiils_title.title = film.title
        //Устанавливаем картинку
        details_poster.setImageResource (film.poster)
        //Устанавливаем описание
        details_description.text = film.description
    }
}




