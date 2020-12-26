package com.mufiid.dicodingbajp.ui.detail_movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.viewmodel.ViewModelFactory
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.databinding.ActivityDetailMovieBinding
import com.mufiid.dicodingbajp.databinding.ContentDetailBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailCourseBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent
        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]


        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                activityDetailCourseBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, Observer {
                    activityDetailCourseBinding.progressBar.visibility = View.INVISIBLE
                    activityDetailCourseBinding.content.visibility = View.VISIBLE
                    populateMovie(it)
                })

            }
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textDate.text =
            resources.getString(R.string.deadline_date, movieEntity.releaseDate)

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)

    }

}