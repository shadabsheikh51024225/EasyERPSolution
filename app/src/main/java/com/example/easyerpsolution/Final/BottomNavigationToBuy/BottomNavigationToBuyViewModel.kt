package com.example.easyerpsolution.Final.BottomNavigationToBuy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomNavigationToBuyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is to buy Fragment"
    }
    val text: LiveData<String> = _text
}