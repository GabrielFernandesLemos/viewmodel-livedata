package com.devlemos.viewmodel.features

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelActivity : ViewModel() {

    private val _param = MutableLiveData<String>()
    val param: LiveData<String> = _param
    var inputValue = ""

    fun onUserSendForm() {
        if (inputValue.isNotEmpty()) {
            _param.value = inputValue
        }
    }

    fun onUserChangedInput(receivedValue: String) {
        inputValue = receivedValue
    }
}