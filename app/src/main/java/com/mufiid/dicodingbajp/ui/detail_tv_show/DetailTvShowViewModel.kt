package com.mufiid.dicodingbajp.ui.detail_tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.data.source.MovieRepository

class DetailTvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<TvShowEntity> = movieRepository.getTvShowById(tvShowId)
}