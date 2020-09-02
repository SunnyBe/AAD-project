package com.sunday.aadproject.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunday.aadproject.R
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val pagerItem: MutableList<String>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pagerItem.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val item = pagerItem[position]
        holder.itemView.tabName.text = item
    }
}