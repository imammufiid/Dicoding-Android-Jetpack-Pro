package com.mufiid.dicodingbajp.ui.bookmark

import com.mufiid.dicodingbajp.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
