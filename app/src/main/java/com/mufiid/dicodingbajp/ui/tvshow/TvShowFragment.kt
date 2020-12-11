package com.mufiid.dicodingbajp.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment(), TvShowFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding =  FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

            val tvShow = viewModel.getTvShow()
            val adapter = TvShowAdapter(this)
            adapter.setCourses(tvShow)

            with(fragmentBookmarkBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(tvShow: TvShowEntity) {
        if(activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setText(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, tvShow.title))
                .startChooser()
        }
    }
}