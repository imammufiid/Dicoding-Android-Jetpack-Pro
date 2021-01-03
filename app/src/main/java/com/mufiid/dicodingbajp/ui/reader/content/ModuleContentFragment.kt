package com.mufiid.dicodingbajp.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mufiid.dicodingbajp.data.source.local.entity.ModuleEntity
import com.mufiid.dicodingbajp.databinding.FragmentModuleContentBinding
import com.mufiid.dicodingbajp.ui.reader.CourseReaderViewModel
import com.mufiid.dicodingbajp.viewmodel.ViewModelFactory
import com.mufiid.dicodingbajp.vo.Status

class ModuleContentFragment : Fragment() {
    private lateinit var viewModel: CourseReaderViewModel
    companion object {
        val TAG: String? = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]

            viewModel.selectedModule.observe(viewLifecycleOwner, {
                if (it != null) {
                    when(it.status) {
                        Status.LOADING -> fragmentModuleContentBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (it.data != null) {
                            fragmentModuleContentBinding.progressBar.visibility = View.GONE
                            if(it.data.contentEntity != null) {
                                populateWebView(it.data)
                            }
                            setButtonNextPrefState(it.data)
                            if(!it.data.read) {
                                viewModel.readContent(it.data)
                            }
                        }
                        Status.ERROR -> {
                            fragmentModuleContentBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }

                    fragmentModuleContentBinding.btnNext.setOnClickListener { viewModel.setNextPage() }
                    fragmentModuleContentBinding.btnPrev.setOnClickListener { viewModel.setPrevPage() }
                }
            })
        }
    }

    private fun setButtonNextPrefState(module: ModuleEntity) {
        if(activity != null) {
            when (module.position) {
                0 -> {
                    fragmentModuleContentBinding.btnPrev.isEnabled = false
                    fragmentModuleContentBinding.btnNext.isEnabled = true
                }
                viewModel.getModuleSize() - 1 -> {
                    fragmentModuleContentBinding.btnPrev.isEnabled = true
                    fragmentModuleContentBinding.btnNext.isEnabled = false
                }
                else -> {
                fragmentModuleContentBinding.btnPrev.isEnabled = true
                fragmentModuleContentBinding.btnNext.isEnabled = true
                }
            }
        }
    }

    private fun populateWebView(module: ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(module?.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

}