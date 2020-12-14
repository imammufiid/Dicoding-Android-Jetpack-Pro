package com.mufiid.dicodingbajp.ui.detail_movie

import com.mufiid.dicodingbajp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var movieViewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun init() {
        movieViewModel = DetailMovieViewModel()
        movieViewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        movieViewModel.setSelectedMovie(dummyMovie.movieId)
        val courseEntity = movieViewModel.getMovie()
        assertNotNull(courseEntity)
        assertEquals(dummyMovie.movieId, courseEntity.movieId)
        assertEquals(dummyMovie.releaseDate, courseEntity.releaseDate)
        assertEquals(dummyMovie.description, courseEntity.description)
        assertEquals(dummyMovie.imagePath, courseEntity.imagePath)
        assertEquals(dummyMovie.title, courseEntity.title)
    }
}