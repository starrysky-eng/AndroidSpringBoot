package com.example.myfirstandroidapp.callBackEndAPI

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitEntity {
    // Connect To AWS baseUrl("https://vn9x0dkce8.execute-api.ap-northeast-1.amazonaws.com")
    // Connect To My SpringBoot baseUrl("http://192.168.2.101:8090")
        val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl("http://192.168.2.101:8090")
            addConverterFactory(GsonConverterFactory.create(Gson()))
        }.build()
    }
}