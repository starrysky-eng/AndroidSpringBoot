package com.example.myfirstandroidapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MyViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
}

