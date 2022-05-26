package com.example.myfirstandroidapp

import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Body

interface CallBackEndAPI {
    @POST("/DIM/save")
    fun save(@Body dimModel: DIMModel):Call<Void>
}