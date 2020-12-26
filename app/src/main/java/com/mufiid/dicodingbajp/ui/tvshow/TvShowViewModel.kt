package com.mufiid.dicodingbajp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.data.source.MovieRepository
import com.mufiid.dicodingbajp.utils.DataDummy

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShowEntity>> = movieRepository.getAllTvShow()
}