package com.mufiid.dicodingbajp.ui.insert

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.source.local.entity.Note
import com.mufiid.dicodingbajp.databinding.ActivityNoteAddUpdateBinding
import com.mufiid.dicodingbajp.helper.DateHelper
import com.mufiid.dicodingbajp.helper.ViewModelFactory

class NoteAddUpdateActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityNoteAddUpdateBinding? = null
    private val binding
        get() = _binding
    private lateinit var viewModel: NoteAddUpdateViewModel

    private var isEdit = false
    private var note: Note? = null
    private var position = 0

    companion object {
        const val EXTRA_NOTE = "extra_note"
        const val EXTRA_POSITION = "extra_position"
        const val REQUEST_ADD = 100
        const val RESULT_ADD = 101
        const val REQUEST_UPDATE = 200
        const val RESULT_UPDATE = 201
        const val RESULT_DELETE = 301
        const val ALERT_DIALOG_CLOSE = 10
        const val ALERT_DIALOG_DELETE = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNoteAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = obtainViewModel(this@NoteAddUpdateActivity)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        if(note != null) {
            position = intent.getIntExtra(EXTRA_POSITION, 0)
            isEdit = true
        } else {
            note = Note()
        }

        val actionBarTitle: String
        val btnTitle: String

        if(isEdit) {
            actionBarTitle = getString(R.string.change)
            btnTitle = getString(R.string.update)

            if(note != null){
                note?.let {
                    binding?.edtTitle?.setText(it.title)
                    binding?.edtDescription?.setText(it.description)
                }
            }
        } else {
            actionBarTitle = getString(R.string.add)
            btnTitle = getString(R.string.save)
        }

        supportActionBar?.title = actionBarTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding?.btnSubmit?.text = btnTitle

        init()
    }

    private fun init() {
        binding?.btnSubmit?.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun obtainViewModel(activity: AppCompatActivity): NoteAddUpdateViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[NoteAddUpdateViewModel::class.java]
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_submit -> {
                val title = binding?.edtTitle?.text.toString().trim()
                val description = binding?.edtDescription?.text.toString().trim()

                if(title.isEmpty()) {
                    binding?.edtTitle?.error = getString(R.string.empty)
                } else if(description.isEmpty()) {
                    binding?.edtDescription?.error = getString(R.string.empty)
                } else {
                    note.let {
                        note?.title = title
                        note?.description = description
                    }

                    val intent = Intent().apply {
                        putExtra(EXTRA_NOTE, note)
                        putExtra(EXTRA_POSITION, position)
                    }

                    if(isEdit) {
                        viewModel.update(note as Note)
                        setResult(RESULT_UPDATE, intent)
                        finish()
                    } else {
                        note.let {
                            it?.date = DateHelper.getCurrentDate()
                        }

                        viewModel.insert(note as Note)
                        setResult(RESULT_ADD, intent)
                        finish()
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(isEdit) {
            menuInflater.inflate(R.menu.menu_form, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_delete -> {
                showAlertDialog(ALERT_DIALOG_DELETE)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onSupportNavigateUp()
        showAlertDialog(ALERT_DIALOG_CLOSE)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        showAlertDialog(ALERT_DIALOG_CLOSE)
    }

    private fun showAlertDialog(type: Int) {
        val isDialogClose: Boolean = type == ALERT_DIALOG_CLOSE
        val dialogTitle: String
        val dialogMessage: String

        if(isDialogClose) {
            dialogTitle = getString(R.string.cancel)
            dialogMessage = getString(R.string.message_cancel)
        } else {
            dialogMessage = getString(R.string.message_delete)
            dialogTitle = getString(R.string.delete)
        }

        AlertDialog.Builder(this).apply {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setPositiveButton(getString(R.string.yes)) { _, _ ->
                if(!isDialogClose) {
                    note?.let { viewModel.delete(it) }
                    setResult(RESULT_DELETE, Intent().putExtra(EXTRA_POSITION, position))
                }
                finish()
            }
            setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.cancel()
            }
        }.show()

    }
}