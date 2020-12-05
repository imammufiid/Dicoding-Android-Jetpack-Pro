package com.mufiid.dicodingbajp.data

data class CourseEntity (
    val courseId: String,
    var title: String,
    var description: String,
    var deadline: String,
    var bookmarked: Boolean = false,
    var imagePath: String
)