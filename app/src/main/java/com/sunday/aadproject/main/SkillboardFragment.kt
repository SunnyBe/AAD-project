package com.sunday.aadproject.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunday.aadproject.R
import com.sunday.aadproject.main.entity.PagerItem
import com.sunday.aadproject.main.util.Content
import kotlinx.android.synthetic.main.fragment_skillboard.*

class SkillboardFragment: Fragment(R.layout.fragment_skillboard) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skillsRecyclerList?.apply {
            adapter = PagerListAdapter(Content.testItems2())
            layoutManager = LinearLayoutManager(context)
        }
    }
}