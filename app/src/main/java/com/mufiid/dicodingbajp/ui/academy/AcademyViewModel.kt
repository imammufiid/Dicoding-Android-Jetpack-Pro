package com.mufiid.dicodingbajp.ui.academy

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.data.source.AcademyRepository
import com.mufiid.dicodingbajp.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourse(): List<CourseEntity> = academyRepository.getAllCourses()
}