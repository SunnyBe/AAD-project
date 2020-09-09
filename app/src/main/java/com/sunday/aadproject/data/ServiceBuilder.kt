package com.sunday.aadproject.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor = interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gadsapi.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private fun makeRetrofit(baseUrl: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun <T> buildService(baseUrl: String="https://gadsapi.herokuapp.com", service: Class<T>): T {
        return makeRetrofit(baseUrl).create(service)
    }
}