package com.mufiid.dicodingbajp.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mufiid.dicodingbajp.R
import com.mufiid.dicodingbajp.ui.academy.AcademyFragment
import com.mufiid.dicodingbajp.ui.bookmark.BookmarkFragment

class SectionPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.home, R.string.bookmark)
        private val TAB_TITTLE_SIZE = TAB_TITLE.size
    }

    override fun getCount(): Int = TAB_TITTLE_SIZE

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> AcademyFragment()
            1 ->BookmarkFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TAB_TITLE[position])
}