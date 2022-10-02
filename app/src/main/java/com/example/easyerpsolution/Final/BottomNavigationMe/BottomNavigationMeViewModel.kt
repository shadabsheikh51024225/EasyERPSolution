package com.example.easyerpsolution.Final.BottomNavigationMe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomNavigationMeViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Me Fragment"
    }
    val text: LiveData<String> = _text
}