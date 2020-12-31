package com.mufiid.dicodingbajp.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.source.local.entity.CourseEntity
import com.mufiid.dicodingbajp.data.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourse(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()
}