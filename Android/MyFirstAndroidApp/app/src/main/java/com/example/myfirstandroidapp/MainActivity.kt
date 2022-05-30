package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
//    private lateinit var binding: ActivityMainBinding
//
//    fun getBinding(): ActivityMainBinding {
//        if(!::binding.isInitialized){
//            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        }
//        return this.binding
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this
//        binding.dao = DAO(this)

    }

}