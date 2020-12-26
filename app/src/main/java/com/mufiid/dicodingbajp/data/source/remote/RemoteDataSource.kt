package com.mufiid.dicodingbajp.data.source.remote

import android.os.Handler
import android.os.Looper
import com.mufiid.dicodingbajp.data.source.remote.response.MovieResponse
import com.mufiid.dicodingbajp.data.source.remote.response.TvShowResponse
import com.mufiid.dicodingbajp.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovie(callback: LoadMovieCallback) {
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovie())
        }, SERVICE_LATENCY_IN_MILLIS)
    }
    fun getAllTvShow(callback: LoadTvShowCallback) {
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }
    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }

}