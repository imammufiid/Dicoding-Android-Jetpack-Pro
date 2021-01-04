package com.mufiid.dicodingbajp.data.source.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.mufiid.dicodingbajp.data.source.local.entity.Note
import com.mufiid.dicodingbajp.data.source.local.entity.NoteDao
import com.mufiid.dicodingbajp.data.source.local.entity.NoteRoomDatabase
import com.mufiid.dicodingbajp.helper.SortUtils
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(sort: String): DataSource.Factory<Int, Note> {
        val query = SortUtils.getSortedQuery(sort)
        return mNotesDao.getAllNotes(query)
    }

    fun insert(note: Note) {
        executorService.execute {
            mNotesDao.insert(note)
        }
    }

    fun delete(note: Note) {
        executorService.execute {
            mNotesDao.delete(note)
        }
    }

    fun update(note: Note) {
        executorService.execute {
            mNotesDao.update(note)
        }
    }
}