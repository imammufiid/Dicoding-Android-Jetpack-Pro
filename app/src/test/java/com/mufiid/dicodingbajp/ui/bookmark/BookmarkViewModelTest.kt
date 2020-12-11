package com.mufiid.dicodingbajp.ui.bookmark

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun init() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmark() {
        val courseEntities = viewModel.getBookmark()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}