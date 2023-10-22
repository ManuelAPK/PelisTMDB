package com.manuelapk.pelis.presenter.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import coil.transform.RoundedCornersTransformation
import com.manuelapk.pelis.data.model.TrendingMovieApi
import com.manuelapk.pelis.databinding.TrendingMovieItemBinding
import com.manuelapk.pelis.domain.model.TrendingMovie
import com.manuelapk.pelis.presenter.base.BaseAdapter
import com.manuelapk.pelis.presenter.utils.Constants.TMDB_IMAGE_URL

class TrendingMoviesAdapter : BaseAdapter<TrendingMovieItemBinding, TrendingMovie>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> TrendingMovieItemBinding
        = TrendingMovieItemBinding::inflate

    override fun loadData(holder: ViewHolder, position: Int, item: TrendingMovie) {
        holder.binding.movieTitle.text = item.title
        holder.binding.movieCover.load(TMDB_IMAGE_URL + item.posterPath) {
            transformations(RoundedCornersTransformation(16f))
        }
    }

}