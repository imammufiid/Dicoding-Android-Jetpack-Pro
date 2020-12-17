package com.mufiid.dicodingbajp.data.source

import com.mufiid.dicodingbajp.data.CourseEntity
import com.mufiid.dicodingbajp.data.ModuleEntity

interface AcademyDataSource {
    fun getAllCourses(): List<CourseEntity>
    fun getBookmarkedCourses(): List<CourseEntity>
    fun getCourseWithModules(courseId: String): CourseEntity
    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>
    fun getContent(courseId: String, moduleId: String): ModuleEntity
}