package com.mufiid.dicodingbajp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.databinding.ItemsTvShowBinding
import com.mufiid.dicodingbajp.ui.detail_tv_show.DetailTvShowActivity

class TvShowAdapter(private val callback: TvShowFragmentCallback): RecyclerView.Adapter<TvShowAdapter.CourseViewHolder>() {
    inner class CourseViewHolder(private val binding: ItemsTvShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDate.text = itemView.resources.getString(R.string.deadline_date, tvShow.releaseDate)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.tvShowId)
                    }
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvShow) }
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    private val listCourses = ArrayList<TvShowEntity>()

    fun setCourses(tvShow: List<TvShowEntity>?) {
        if(tvShow == null)  return
        this.listCourses.clear()
        this.listCourses.addAll(tvShow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val itemsBookmarkBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return CourseViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size

}