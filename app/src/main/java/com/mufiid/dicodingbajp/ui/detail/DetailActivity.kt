package com.mufiid.dicodingbajp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.databinding.ActivityDetailBinding
import com.mufiid.dicodingbajp.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailCourseBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent
        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]


        val extras = intent.extras
        if(extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if(movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateCourse(viewModel.getMovie())

            }
        }

    }

    private fun populateCourse(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, movieEntity.releaseDate)

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

    }

}