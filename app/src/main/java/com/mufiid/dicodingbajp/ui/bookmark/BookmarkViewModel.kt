package com.mufiid.dicodingbajp.ui.bookmark

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmark(): List<CourseEntity> = DataDummy.generateDummyCourses()
}