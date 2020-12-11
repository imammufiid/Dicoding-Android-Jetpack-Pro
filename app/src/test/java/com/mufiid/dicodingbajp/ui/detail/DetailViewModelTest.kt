package com.mufiid.dicodingbajp.ui.detail

import com.mufiid.dicodingbajp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyCourse = DataDummy.generateDummyMovies()[0]
    private val courseId = dummyCourse.movieId

    @Before
    fun init() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(courseId)
    }


    @Test
    fun getCourse() {
        viewModel.setSelectedMovie(dummyCourse.movieId)
        val courseEntity = viewModel.getMovie()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.movieId, courseEntity.movieId)
        assertEquals(dummyCourse.releaseDate, courseEntity.releaseDate)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }
}