package com.mufiid.dicodingbajp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.source.local.entity.Note
import com.mufiid.dicodingbajp.databinding.ActivityMainBinding
import com.mufiid.dicodingbajp.helper.ViewModelFactory
import com.mufiid.dicodingbajp.ui.insert.NoteAddUpdateActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = obtainViewModel(this@MainActivity)

        adapter = NoteAdapter(this@MainActivity)
        setRecyclerView()
        init()

    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNotes().observe(this, noteObserve)
    }

    private fun init() {
        binding?.fabAdd?.setOnClickListener(this)
    }

    private val noteObserve = Observer<List<Note>> {
        if(it != null) {
            adapter.setListNotes(it)
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MainViewModel::class.java]
    }

    private fun setRecyclerView() {
        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.fab_add -> {
                val intent = Intent(this, NoteAddUpdateActivity::class.java)
                startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_ADD)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null) {
            if(requestCode == NoteAddUpdateActivity.REQUEST_ADD) {
                if(resultCode == NoteAddUpdateActivity.RESULT_ADD) {
                    showSnackbarMessage(getString(R.string.added))
                }
            } else if(requestCode == NoteAddUpdateActivity.REQUEST_UPDATE) {
                if(resultCode == NoteAddUpdateActivity.RESULT_UPDATE) {
                    showSnackbarMessage(getString(R.string.changed))
                } else if(resultCode == NoteAddUpdateActivity.RESULT_DELETE) {
                    showSnackbarMessage(getString(R.string.deleted))
                }
            }
        }
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding?.root as View, message, Snackbar.LENGTH_SHORT).show()
    }


}