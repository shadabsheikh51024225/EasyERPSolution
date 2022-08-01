package com.example.easyerpsolution.ui.BottomNavigationGals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomNavigationGalViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is gal Fragment"
    }
    val text: LiveData<String> = _text
}