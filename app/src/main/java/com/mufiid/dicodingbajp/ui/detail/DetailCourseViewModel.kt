package com.mufiid.dicodingbajp.ui.detail

import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.data.ModuleEntity
import com.mufiid.dicodingbajp.utils.DataDummy

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourses()
        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModule(courseId)
}