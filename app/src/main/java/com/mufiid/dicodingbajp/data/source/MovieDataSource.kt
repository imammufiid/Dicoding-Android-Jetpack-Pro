package com.mufiid.dicodingbajp.data.source

import androidx.lifecycle.LiveData
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.TvShowEntity

interface MovieDataSource {
    fun getAllMovie(): LiveData<List<MovieEntity>>
    fun getAllTvShow(): LiveData<List<TvShowEntity>>
    fun getMovieById(movieId: String): LiveData<MovieEntity>
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>
}