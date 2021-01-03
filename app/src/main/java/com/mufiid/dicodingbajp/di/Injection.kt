package com.mufiid.dicodingbajp.di

import android.content.Context
import com.mufiid.dicodingbajp.data.AcademyRepository
import com.mufiid.dicodingbajp.data.source.local.LocalDataSource
import com.mufiid.dicodingbajp.data.source.local.room.AcademyDatabase
import com.mufiid.dicodingbajp.data.source.remote.RemoteDataSource
import com.mufiid.dicodingbajp.utils.AppExecutor
import com.mufiid.dicodingbajp.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {
        val database = AcademyDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutor()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}