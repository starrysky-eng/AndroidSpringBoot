package com.example.myfirstandroidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userData = arguments?.getStringArrayList("UserData")
        val name = getView()?.findViewById<TextView>(R.id.textView3)
        val password = getView()?.findViewById<TextView>(R.id.textView4)
        name?.text = userData?.get(0)
        password?.text = userData?.get(1)
    }
}