package com.mufiid.dicodingbajp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mufiid.dicodingbajp.data.AcademyRepository
import com.mufiid.dicodingbajp.di.Injection
import com.mufiid.dicodingbajp.ui.academy.AcademyViewModel
import com.mufiid.dicodingbajp.ui.bookmark.BookmarkViewModel
import com.mufiid.dicodingbajp.ui.detail.DetailCourseViewModel
import com.mufiid.dicodingbajp.ui.reader.CourseReaderViewModel


class ViewModelFactory private constructor(private val mAcademyRepository: AcademyRepository) :
    ViewModelProvider.NewInstanceFactory() {


    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                AcademyViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                DetailCourseViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                CourseReaderViewModel(mAcademyRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class : ${modelClass.name}")
        }
    }
}