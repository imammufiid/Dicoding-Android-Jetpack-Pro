package com.mufiid.dicodingbajp.ui.detail_tv_show

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.databinding.ActivityDetailTvShowBinding
import com.mufiid.dicodingbajp.databinding.ContentDetailBinding

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailBinding

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]


        val extras = intent.extras
        if(extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if(tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow())

            }
        }

    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.textTitle.text = tvShowEntity.title
        detailContentBinding.textDescription.text = tvShowEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, tvShowEntity.releaseDate)

        Glide.with(this)
            .load(tvShowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

    }

}