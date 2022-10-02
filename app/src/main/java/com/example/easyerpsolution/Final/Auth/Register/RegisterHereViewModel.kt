package com.example.easyerpsolution.Final.Auth.Register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyerpsolution.Final.Auth.RetroInstance
import com.example.easyerpsolution.Final.Auth.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterHereViewModel : ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<UserResponseRegister?>
    protected var SuccessResponse = false
    init {
        createNewUserLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<UserResponseRegister?> {
        return createNewUserLiveData
    }


    fun createNewUser(user: RegisterUserDataModel) {
        val retroService  = RetroInstance.getRetroInstance().create(RetrofitAPI::class.java)
        val call = retroService.createUser(user)
        call.enqueue(object: Callback<UserResponseRegister> {
            override fun onFailure(call: Call<UserResponseRegister>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponseRegister>, response: Response<UserResponseRegister>) {
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