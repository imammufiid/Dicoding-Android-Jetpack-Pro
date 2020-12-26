package com.mufiid.dicodingbajp.utils

import android.content.Context
import com.mufiid.dicodingbajp.data.source.remote.response.MovieResponse
import com.mufiid.dicodingbajp.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val releaseDate = movie.getString("releaseDate")
                val runtime = movie.getString("runtime")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(id, title, description, releaseDate, runtime, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tv_show")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val releaseDate = movie.getString("releaseDate")
                val runtime = movie.getString("runtime")
                val imagePath = movie.getString("imagePath")

                val tvShowResponse = TvShowResponse(id, title, description, releaseDate, runtime, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}