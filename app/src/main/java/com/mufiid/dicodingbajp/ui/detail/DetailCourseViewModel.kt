package com.mufiid.dicodingbajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mufiid.dicodingbajp.data.source.local.entity.CourseEntity
import com.mufiid.dicodingbajp.data.source.local.entity.ModuleEntity
import com.mufiid.dicodingbajp.data.AcademyRepository
import com.mufiid.dicodingbajp.data.source.local.entity.CourseWithModule
import com.mufiid.dicodingbajp.vo.Resource

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    val courseId = MutableLiveData<String>()

    fun setSelectedCourse(courseId: String) {
        this.courseId.value = courseId
    }

    var courseModule: LiveData<Resource<CourseWithModule>> = Transformations.switchMap(courseId) {
        academyRepository.getCourseWithModules(it)
    }

    fun setBookmark() {
        val moduleResource = courseModule.value
        if(moduleResource != null) {
            val courseWithModule = moduleResource.data

            if(courseWithModule != null) {
                val courseEntity = courseWithModule.mCourse
                val newState = !courseEntity.bookmarked
                academyRepository.setCourseBookmark(courseEntity, newState)
            }
        }
    }

//    fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)
//
//    fun getModules(): LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseId)
}