package com.mufiid.dicodingbajp.data.source.remote

import android.os.Handler
import android.os.Looper
import com.mufiid.dicodingbajp.data.source.remote.response.ContentResponse
import com.mufiid.dicodingbajp.data.source.remote.response.CourseResponse
import com.mufiid.dicodingbajp.data.source.remote.response.ModuleResponse
import com.mufiid.dicodingbajp.utils.EspressoIdlingResource
import com.mufiid.dicodingbajp.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllCourses(callback: LoadCoursesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllCoursesReceived(jsonHelper.loadCourses())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

    }

    fun getModules(courseId: String, callback: LoadModulesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllModulesReceived(jsonHelper.loadModule(courseId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getContent(moduleId: String, callback: LoadContentCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onContentReceived(jsonHelper.loadContent(moduleId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponses: List<CourseResponse>)
    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponse: List<ModuleResponse>)
    }

    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }
}