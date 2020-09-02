package com.sunday.aadproject.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sunday.aadproject.R
import com.sunday.aadproject.main.entity.PagerItem
import kotlinx.android.synthetic.main.item_selection_view.view.*

class PagerListAdapter(val pagerItems: MutableList<PagerItem>) : RecyclerView.Adapter<PagerListAdapter.PagerListViewHolder>() {
    inner class PagerListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_selection_view, parent, false)
        return PagerListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pagerItems.size
    }

    override fun onBindViewHolder(holder: PagerListViewHolder, position: Int) {
        val pagerItem = pagerItems[position]
        holder.itemView.itemTitle.text = pagerItem.name
        holder.itemView.item_content.text = pagerItem.country
        Picasso.get()
            .load(pagerItem.badgeUrl)
            .resize(50, 50)
            .centerCrop()
            .placeholder(R.drawable.skill_iq_trimmed)
            .into(holder.itemView.itemImage)
    }

    fun replaceItems(items: List<PagerItem>) {
        pagerItems.clear()
        pagerItems.addAll(items)
        notifyDataSetChanged()
    }

    fun updateItems(items: List<PagerItem>) {
        pagerItems.addAll(items)
        notifyDataSetChanged()
    }
}