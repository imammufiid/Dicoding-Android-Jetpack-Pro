package com.mufiid.dicodingbajp.ui.detail_tv_show

import com.mufiid.dicodingbajp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailTvShowViewModelTest {
    private lateinit var movieViewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun init() {
        movieViewModel = DetailTvShowViewModel()
        movieViewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        movieViewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val courseEntity = movieViewModel.getTvShow()
        assertNotNull(courseEntity)
        assertEquals(dummyTvShow.tvShowId, courseEntity.tvShowId)
        assertEquals(dummyTvShow.releaseDate, courseEntity.releaseDate)
        assertEquals(dummyTvShow.description, courseEntity.description)
        assertEquals(dummyTvShow.imagePath, courseEntity.imagePath)
        assertEquals(dummyTvShow.title, courseEntity.title)
    }
}