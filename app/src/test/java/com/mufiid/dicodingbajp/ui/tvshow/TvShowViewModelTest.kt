package com.mufiid.dicodingbajp.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun init() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val courseEntities = viewModel.getTvShow()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }
}