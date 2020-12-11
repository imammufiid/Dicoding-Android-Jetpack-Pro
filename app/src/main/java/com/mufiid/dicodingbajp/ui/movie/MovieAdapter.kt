package com.mufiid.dicodingbajp.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.databinding.ItemsMovieBinding
import com.mufiid.dicodingbajp.ui.detail.DetailActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.CourseViewHolder>() {
    class CourseViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = itemView.resources.getString(R.string.deadline_date, movie.releaseDate)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

    private var listCourse = ArrayList<MovieEntity>()

    fun setCourses(movie: List<MovieEntity>?) {
        if(movie == null) return
        this.listCourse.clear()
        this.listCourse.addAll(movie)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        val itemsAcademyBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.CourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size
}