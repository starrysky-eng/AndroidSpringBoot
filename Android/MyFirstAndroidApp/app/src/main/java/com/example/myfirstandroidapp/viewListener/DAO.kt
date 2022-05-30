package com.example.myfirstandroidapp.viewListener

import android.text.TextUtils
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.example.myfirstandroidapp.callBackEndAPI.CallBackEndAPI
import com.example.myfirstandroidapp.callBackEndAPI.RetrofitEntity
import com.example.myfirstandroidapp.dataEntity.DIMModel
import com.example.myfirstandroidapp.databinding.FragmentHomePageBinding
import com.example.myfirstandroidapp.viewModel.MyViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

class DAO(fragmentBinding: FragmentHomePageBinding, val myViewModel: MyViewModel, private val activity: FragmentActivity?) {
    private val binding = fragmentBinding
    private val retrofitEntity = RetrofitEntity()
    private val callBackEndAPI: CallBackEndAPI = retrofitEntity.retrofit.create(CallBackEndAPI::class.java)

    fun onCheckChange(compoundButton: CompoundButton, checked: Boolean) {
        if (checked) {
            myViewModel.currentName.value = "开"

        } else {
            myViewModel.currentName.value = "关"
        }
    }

    fun onClick() {
        var input = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(input)) {
            input = "0"
        } else {
            binding.progressBar1.progress = Integer.valueOf(input)
            myViewModel.currentName.value = input
        }
    }

    fun onProgressChanged(seekBar: SeekBar, i: Int, fromUser: Boolean) {
        myViewModel.currentName.value = i.toString()
    }

    fun onStartTrackingTouch(seekBar: SeekBar) {
        Toast.makeText(activity, "start tracking", Toast.LENGTH_SHORT).show()
    }

    fun onStopTrackingTouch(seekBar: SeekBar) {
        Toast.makeText(activity, "stop tracking", Toast.LENGTH_SHORT).show()
    }

    fun onClickSignUpButton(){
        val name = binding.editTextNumber2.text.toString()
        val passWord = binding.editTextTextPassword.text.toString()
        val userMessage = DIMModel()

        userMessage.name = name
        userMessage.password = passWord

        callBackEndAPI.save(userMessage)
            .enqueue(object: Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(activity,"Save Successful!!",Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(activity,"Save Failed!!",Toast.LENGTH_SHORT).show()
                    Logger.getLogger(CallBackEndAPI::class.java.name).log(Level.SEVERE,"Error",t)
                }
            })
    }
}