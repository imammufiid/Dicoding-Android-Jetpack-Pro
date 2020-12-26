package com.mufiid.dicodingbajp.ui.detail_movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.source.MovieRepository
import com.mufiid.dicodingbajp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var movieViewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun init() {
        movieViewModel = DetailMovieViewModel(movieRepository)
        movieViewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(movieRepository.getMovieById(movieId)).thenReturn(movie)
        val courseEntity = movieViewModel.getMovie().value as MovieEntity
        verify(movieRepository).getMovieById(movieId)
        assertNotNull(courseEntity)
        assertEquals(dummyMovie.movieId, courseEntity.movieId)
        assertEquals(dummyMovie.releaseDate, courseEntity.releaseDate)
        assertEquals(dummyMovie.description, courseEntity.description)
        assertEquals(dummyMovie.imagePath, courseEntity.imagePath)
        assertEquals(dummyMovie.title, courseEntity.title)

        movieViewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}