package com.mufiid.dicodingbajp.ui.academy

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.utils.DataDummy

class AcademyViewModel: ViewModel() {

    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses()
}