package com.sunday.aadproject.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sunday.aadproject.R
import com.sunday.aadproject.data.LeaderSkillService
import com.sunday.aadproject.data.ServiceBuilder
import com.sunday.aadproject.main.util.Content
import com.sunday.aadproject.submission.SubmissionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var viewPager: ViewPager2
    lateinit var leaderSkillService: LeaderSkillService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager = findViewById<ViewPager2>(R.id.main_view_pager)

        leaderSkillService = ServiceBuilder.buildService(
            service = LeaderSkillService::class.java
        )

        toolbarSubmitButton?.setOnClickListener {
            startActivity(Intent(this, SubmissionActivity::class.java))
        }

        findViewById<ViewPager2>(R.id.main_view_pager)?.apply {
            adapter = LeaderBoardPagerAdapter(this@MainActivity)
            TabLayoutMediator(
                main_tab_layout,
                findViewById<ViewPager2>(R.id.main_view_pager)
            ) { tab, position ->
                tab.text = Content.slideList()[position].capitalize()
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
                0 -> LeaderboardFragment(leaderSkillService, listLoadingProgress)
                else -> SkillboardFragment(leaderSkillService, listLoadingProgress)
            }
        }

    }
}