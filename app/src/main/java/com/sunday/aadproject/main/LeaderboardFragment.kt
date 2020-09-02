package com.sunday.aadproject.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunday.aadproject.R
import com.sunday.aadproject.main.util.Content
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class LeaderboardFragment: Fragment(R.layout.fragment_leaderboard) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leadersRecyclerList?.apply {
            adapter = PagerListAdapter(Content.testItems())
            layoutManager = LinearLayoutManager(context)
        }
    }
}