package com.mufiid.dicodingbajp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mufiid.dicodingbajp.data.source.remote.RemoteDataSource
import com.mufiid.dicodingbajp.utils.DataDummy
import com.mufiid.dicodingbajp.utils.LiveDataUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieRepositoryTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].movieId
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].tvShowId

    @Test
    fun getAllMovie() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovie(any())
        val movieEntities = LiveDataUtil.getValue(movieRepository.getAllMovie())
        verify(remote).getAllMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataUtil.getValue(movieRepository.getAllTvShow())
        verify(remote).getAllTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovie(any())
        val resultMovie = LiveDataUtil.getValue(movieRepository.getMovieById(movieId))
        verify(remote).getAllMovie(any())
        assertNotNull(resultMovie)
        assertEquals(movieResponse[0].title, resultMovie.title)
    }

    @Test
    fun getTvShowById() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val resultTvShow = LiveDataUtil.getValue(movieRepository.getTvShowById(tvShowId))
        verify(remote).getAllTvShow(any())
        assertNotNull(resultTvShow)
        assertEquals(tvShowResponse[0].title, resultTvShow.title)
    }

}