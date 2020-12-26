package com.mufiid.dicodingbajp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.source.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getAllMovie()
}