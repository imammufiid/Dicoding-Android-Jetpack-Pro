package com.mufiid.dicodingbajp.data

import androidx.room.ColumnInfo

data class ContentEntity (
    @ColumnInfo(name = "content")
    var content: String?
)