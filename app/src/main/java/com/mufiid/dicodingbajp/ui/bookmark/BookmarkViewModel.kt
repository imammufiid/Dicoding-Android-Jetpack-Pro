package com.mufiid.dicodingbajp.ui.bookmark

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.data.source.AcademyRepository
import com.mufiid.dicodingbajp.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getBookmark(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
}