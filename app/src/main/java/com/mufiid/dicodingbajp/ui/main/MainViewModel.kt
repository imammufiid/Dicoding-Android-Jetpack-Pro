package com.mufiid.dicodingbajp.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mufiid.dicodingbajp.data.source.local.entity.Note
import com.mufiid.dicodingbajp.data.source.repository.NoteRepository

class MainViewModel(application: Application): ViewModel() {
    private val mNoteRepository = NoteRepository(application)

    fun getAllNotes(sort: String): LiveData<PagedList<Note>> = LivePagedListBuilder(mNoteRepository.getAllNotes(sort), 20).build()
}