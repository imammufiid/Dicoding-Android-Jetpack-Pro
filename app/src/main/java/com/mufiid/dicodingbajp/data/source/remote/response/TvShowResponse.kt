package com.mufiid.dicodingbajp.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse (
    var tvShowId: String,
    var title: String,
    var description: String,
    var releaseDate: String,
    var runtime: String,
    var imagePath: String
) : Parcelable