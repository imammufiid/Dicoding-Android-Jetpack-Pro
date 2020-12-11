package com.mufiid.dicodingbajp.ui.movie

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.utils.DataDummy

class MovieViewModel: ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}