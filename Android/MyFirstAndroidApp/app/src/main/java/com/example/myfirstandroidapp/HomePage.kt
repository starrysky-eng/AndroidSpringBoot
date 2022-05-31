package com.example.myfirstandroidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.myfirstandroidapp.databinding.FragmentHomePageBinding
import com.example.myfirstandroidapp.viewListener.DAO
import com.example.myfirstandroidapp.viewModel.MyViewModel

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private val myViewModel: MyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dao = DAO(binding,myViewModel,activity)
    }

}