package com.sunday.aadproject.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunday.aadproject.R
import com.sunday.aadproject.data.LeaderSkillService
import com.sunday.aadproject.main.entity.PagerItem
import com.sunday.aadproject.main.util.internetConnected
import com.sunday.aadproject.main.util.toastMsg
import kotlinx.android.synthetic.main.fragment_skillboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkillboardFragment(private val apiService: LeaderSkillService): Fragment(R.layout.fragment_skillboard) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.apply{
            if (internetConnected()) fetchList() else toastMsg(resources.getString(R.string.no_internet))
        }
    }

    private fun fetchList() {
        apiService.skillIq().enqueue(object: Callback<MutableList<PagerItem>> {
            override fun onFailure(call: Call<MutableList<PagerItem>>, t: Throwable) {
                Toast.makeText(activity, R.string.api_request_failed, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<MutableList<PagerItem>>,
                response: Response<MutableList<PagerItem>>
            ) {
                Log.d(this@SkillboardFragment.javaClass.simpleName, "${response.body()}")
                response.body()?.let { list->
                    skillsRecyclerList?.apply {
                        adapter = PagerListAdapter(list)
                        layoutManager = LinearLayoutManager(context)
                    }
                }
            }

        })
    }
}