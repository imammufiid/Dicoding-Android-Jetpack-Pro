package com.mufiid.dicodingbajp.ui.bookmark

import com.mufiid.dicodingbajp.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
