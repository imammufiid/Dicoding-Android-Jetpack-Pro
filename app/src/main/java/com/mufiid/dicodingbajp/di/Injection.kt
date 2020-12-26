package com.mufiid.dicodingbajp.di

import android.content.Context
import com.mufiid.dicodingbajp.data.source.MovieRepository
import com.mufiid.dicodingbajp.data.source.remote.RemoteDataSource
import com.mufiid.dicodingbajp.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}