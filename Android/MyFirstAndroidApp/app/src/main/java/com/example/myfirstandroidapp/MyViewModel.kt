package com.example.myfirstandroidapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MyViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
}

