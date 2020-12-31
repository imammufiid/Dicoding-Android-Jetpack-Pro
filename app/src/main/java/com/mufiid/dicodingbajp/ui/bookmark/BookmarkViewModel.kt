package com.mufiid.dicodingbajp.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.source.local.entity.CourseEntity
import com.mufiid.dicodingbajp.data.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getBookmark(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}