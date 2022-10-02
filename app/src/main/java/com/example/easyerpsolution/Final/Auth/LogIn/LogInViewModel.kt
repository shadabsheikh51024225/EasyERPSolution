package com.example.easyerpsolution.Final.Auth.LogIn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyerpsolution.Final.Auth.Register.UserResponseRegister
import com.example.easyerpsolution.Final.Auth.RetroInstance
import com.example.easyerpsolution.Final.Auth.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInViewModel : ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<UserResponseLogIn?>
    protected var SuccessResponse = false
    init {
        createNewUserLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<UserResponseLogIn?> {
        return createNewUserLiveData
    }


    fun LogInUser(user: LogInUserDataModel) {
        val retroService  = RetroInstance.getRetroInstance().create(RetrofitAPI::class.java)
        val call = retroService.LogInUser(user)
        call.enqueue(object: Callback<UserResponseLogIn> {
            override fun onFailure(call: Call<UserResponseLogIn>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponseLogIn>, response: Response<UserResponseLogIn>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                    SuccessResponse = true
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })
    }


}