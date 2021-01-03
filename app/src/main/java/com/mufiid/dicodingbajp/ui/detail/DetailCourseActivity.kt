package com.mufiid.dicodingbajp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.source.local.entity.CourseEntity
import com.mufiid.dicodingbajp.databinding.ActivityDetailCourseBinding
import com.mufiid.dicodingbajp.databinding.ContentDetailCourseBinding
import com.mufiid.dicodingbajp.ui.reader.CourseReaderActivity
import com.mufiid.dicodingbajp.viewmodel.ViewModelFactory
import com.mufiid.dicodingbajp.vo.Status

class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailCourseBinding
    private lateinit var binding: ActivityDetailCourseBinding
    private lateinit var viewModel: DetailCourseViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = binding.detailContent
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]
        val adapter = DetailCourseAdapter()

        val extras = intent.extras
        if(extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if(courseId != null) {

                viewModel.setSelectedCourse(courseId)

                viewModel.courseModule.observe(this, {
                    if(it != null) {
                        when(it.status) {
                            Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (it.data != null) {
                                binding.progressBar.visibility = View.GONE
                                binding.content.visibility = View.VISIBLE

                                adapter.setModules(it.data.mModules)
                                adapter.notifyDataSetChanged()
                                populateCourse(it.data.mCourse)
                            }
                            Status.ERROR -> {
                                binding.progressBar.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this@DetailCourseActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu

        viewModel.courseModule.observe(this, {
            if(it != null) {
                when(it.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (it.data != null) {
                        binding.progressBar.visibility = View.GONE
                        val state = it.data.mCourse.bookmarked
                        setBookmarkedState(state)
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            viewModel.setBookmark()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkedState(state: Boolean) {
        if(menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.textDescription.text = courseEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }

}