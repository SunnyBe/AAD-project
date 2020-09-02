package com.sunday.aadproject.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sunday.aadproject.R
import com.sunday.aadproject.main.util.Content
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var viewPager: ViewPager2
    val defaultAdapter = PagerListAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager = findViewById<ViewPager2>(R.id.main_view_pager)

        // Item select listener using Material toolbar
        toolbar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.submit_icon -> {
                    true
                }
                else -> false
            }
        }

        findViewById<ViewPager2>(R.id.main_view_pager)?.apply {
            adapter = LeaderBoardPagerAdapter(this@MainActivity)
            TabLayoutMediator(
                main_tab_layout,
                findViewById<ViewPager2>(R.id.main_view_pager)
            ) { tab, position ->
                tab.text = Content.slideList()[position]
            }.attach()

        }
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class LeaderBoardPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LeaderboardFragment()
                else -> SkillboardFragment()
            }
        }

    }
}