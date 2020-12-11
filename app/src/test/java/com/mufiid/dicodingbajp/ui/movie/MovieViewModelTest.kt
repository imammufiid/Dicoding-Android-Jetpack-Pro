package com.mufiid.dicodingbajp.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun init() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getMovies()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }
}