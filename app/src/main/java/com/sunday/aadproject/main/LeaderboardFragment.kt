package com.sunday.aadproject.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sunday.aadproject.R
import com.sunday.aadproject.data.LeaderSkillService
import com.sunday.aadproject.main.entity.PagerItem
import com.sunday.aadproject.main.util.internetConnected
import com.sunday.aadproject.main.util.toastMsg
import kotlinx.android.synthetic.main.fragment_leaderboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaderboardFragment(private val apiService: LeaderSkillService, private val progressBar: ProgressBar): Fragment(R.layout.fragment_leaderboard), SwipeRefreshLayout.OnRefreshListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leaderSwipeToRefresh?.setOnRefreshListener(this)

        activity?.apply{
           if (internetConnected()) fetchList() else toastMsg(resources.getString(R.string.no_internet))
        }
    }

    private fun fetchList() {
        showProgress()
        apiService.hours().enqueue(object: Callback<MutableList<PagerItem>> {
            override fun onFailure(call: Call<MutableList<PagerItem>>, t: Throwable) {
                hideProgress()
                Toast.makeText(activity, R.string.api_request_failed, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<MutableList<PagerItem>>,
                response: Response<MutableList<PagerItem>>
            ) {
                hideProgress()
                Log.d(this@LeaderboardFragment.javaClass.simpleName, "${response.body()}")
                response.body()?.let { list->
                    leadersRecyclerList?.apply {
                        adapter = PagerListAdapter(list)
                        layoutManager = LinearLayoutManager(context)
                    }
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        hideProgress()
    }

    override fun onRefresh() {
        leaderSwipeToRefresh?.isRefreshing = false
        activity?.apply{
            if (internetConnected()) fetchList() else toastMsg(resources.getString(R.string.no_internet))
        }
    }

    private fun showProgress() {
        activity?.runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }
    }
    private fun hideProgress() {
        activity?.runOnUiThread {
            if (progressBar.isVisible) progressBar.visibility = View.GONE
        }
    }
}