package com.sakal_n.myapplicationcinemasearch.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import com.sakal_n.myapplicationcinemasearch.databinding.FilmItemBinding
import com.bumptech.glide.Glide
import ru.sakal.core_impl.entity.ApiConstants


class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val filmItemBinding = FilmItemBinding.bind(itemView)

    private val title = filmItemBinding.title
    private val poster = filmItemBinding.poster
    private val description = filmItemBinding.description

    private val ratingDonut = filmItemBinding.ratingDonut


    fun bind(film: Film) {
        title.text = film.title
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())

    }

}