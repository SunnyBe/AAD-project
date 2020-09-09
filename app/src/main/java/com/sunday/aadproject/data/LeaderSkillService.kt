package com.sunday.aadproject.data

import com.sunday.aadproject.main.entity.PagerItem
import retrofit2.Call
import retrofit2.http.GET

interface LeaderSkillService {

    @GET("/api/hours")
    fun hours(): Call<MutableList<PagerItem>>

    @GET("/api/skilliq")
    fun skillIq(): Call<MutableList<PagerItem>>
}