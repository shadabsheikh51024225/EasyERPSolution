package com.example.easyerpsolution.Final.Auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers

import retrofit2.http.POST


interface RetrofitAPI {

    @Headers("Content-Type: application/json")
    @POST("register")
    fun addUser(@Body userData: RegisterUserDataModel): Call<RegisterUserDataModel>
}