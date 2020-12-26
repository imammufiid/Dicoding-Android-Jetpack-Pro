package com.mufiid.dicodingbajp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mufiid.dicodingbajp.data.source.MovieRepository
import com.mufiid.dicodingbajp.di.Injection
import com.mufiid.dicodingbajp.ui.detail_movie.DetailMovieViewModel
import com.mufiid.dicodingbajp.ui.detail_tv_show.DetailTvShowViewModel
import com.mufiid.dicodingbajp.ui.movie.MovieViewModel
import com.mufiid.dicodingbajp.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context) : ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }
}