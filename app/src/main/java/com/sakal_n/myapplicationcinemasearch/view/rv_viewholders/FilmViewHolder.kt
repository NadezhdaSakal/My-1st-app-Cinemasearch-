package com.sakal_n.myapplicationcinemasearch.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sakal_n.myapplicationcinemasearch.domain.Film
import kotlinx.android.synthetic.main.film_item.view.*
import com.bumptech.glide.Glide

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description
    private val ratingDonut = itemView.rating_donut


    fun bind(film: Film) {
        title.text = film.title
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())

    }

}