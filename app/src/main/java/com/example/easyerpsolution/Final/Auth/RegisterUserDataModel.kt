package com.example.easyerpsolution.Final.Auth

import com.google.gson.annotations.SerializedName

data class RegisterUserDataModel(
    @SerializedName("name") val userName: String?,
    @SerializedName("email") val userEmail: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("password_confirmation") val password_confirmation: String?
) {
}