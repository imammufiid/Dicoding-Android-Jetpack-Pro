package com.mufiid.dicodingbajp.ui.detail

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.data.ModuleEntity
import com.mufiid.dicodingbajp.data.source.AcademyRepository
import com.mufiid.dicodingbajp.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}