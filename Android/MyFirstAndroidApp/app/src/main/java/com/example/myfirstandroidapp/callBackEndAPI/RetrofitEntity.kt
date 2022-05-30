package com.example.myfirstandroidapp.callBackEndAPI

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitEntity {
        val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl("https://vn9x0dkce8.execute-api.ap-northeast-1.amazonaws.com")
            addConverterFactory(GsonConverterFactory.create(Gson()))
        }.build()
    }
}