package com.mufiid.dicodingbajp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}