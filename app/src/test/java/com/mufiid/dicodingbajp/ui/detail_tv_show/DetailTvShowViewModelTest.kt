package com.mufiid.dicodingbajp.ui.detail_tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.TvShowEntity
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
class DetailTvShowViewModelTest {
    private lateinit var movieViewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Before
    fun init() {
        movieViewModel = DetailTvShowViewModel(movieRepository)
        movieViewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val courseEntity = movieViewModel.getTvShow().value as TvShowEntity
        verify(movieRepository).getTvShowById(tvShowId)
        assertNotNull(courseEntity)
        assertEquals(dummyTvShow.tvShowId, courseEntity.tvShowId)
        assertEquals(dummyTvShow.releaseDate, courseEntity.releaseDate)
        assertEquals(dummyTvShow.description, courseEntity.description)
        assertEquals(dummyTvShow.imagePath, courseEntity.imagePath)
        assertEquals(dummyTvShow.title, courseEntity.title)

        movieViewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}