package com.example.easyerpsolution.Final.Auth

import com.example.easyerpsolution.Final.Auth.LogIn.LogInUserDataModel
import com.example.easyerpsolution.Final.Auth.LogIn.UserResponseLogIn
import com.example.easyerpsolution.Final.Auth.Register.RegisterUserDataModel
import com.example.easyerpsolution.Final.Auth.Register.UserResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers

import retrofit2.http.POST


interface RetrofitAPI {
    @POST("register")
    @Headers("Accept:application/json", "Content-Type:application/json","Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun createUser(@Body params: RegisterUserDataModel): Call<UserResponseRegister>

    @POST("login")
    @Headers("Accept:application/json", "Content-Type:application/json","Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun LogInUser(@Body params: LogInUserDataModel): Call<UserResponseLogIn>
}