package com.example.myfirstandroidapp

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitEntity {
        val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl("http://192.168.2.101:8090")
            addConverterFactory(GsonConverterFactory.create(Gson()))
        }.build()
    }

//    val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://192.168.2.101:8090")
//        .addConverterFactory(GsonConverterFactory.create(Gson()))
//        .build()
}