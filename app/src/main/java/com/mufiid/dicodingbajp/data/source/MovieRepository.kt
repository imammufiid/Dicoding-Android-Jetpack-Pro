package com.mufiid.dicodingbajp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.data.source.remote.RemoteDataSource
import com.mufiid.dicodingbajp.data.source.remote.response.MovieResponse
import com.mufiid.dicodingbajp.data.source.remote.response.TvShowResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource)
            }
    }

    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object: RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val course = MovieEntity(response.movieId,
                        response.title,
                        response.description,
                        response.releaseDate,
                        response.runtime,
                        response.imagePath)
                    movieList.add(course)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object: RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val course = TvShowEntity(response.tvShowId,
                        response.title,
                        response.description,
                        response.releaseDate,
                        response.runtime,
                        response.imagePath)
                    tvShowList.add(course)
                }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    override fun getMovieById(movieId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponse) {
                    if (response.movieId == movieId) {
                        movie = MovieEntity(response.movieId,
                            response.title,
                            response.description,
                            response.releaseDate,
                            response.runtime,
                            response.imagePath)
                        movieResult.postValue(movie)
                    }
                }
            }
        })

        return movieResult
    }

    override fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowResponse) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowEntity(response.tvShowId,
                            response.title,
                            response.description,
                            response.releaseDate,
                            response.runtime,
                            response.imagePath)
                        tvShowResult.postValue(tvShow)
                    }
                }
            }
        })
        return tvShowResult
    }

}