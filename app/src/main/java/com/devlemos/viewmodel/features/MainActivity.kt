package com.devlemos.viewmodel.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devlemos.viewmodel.R
import com.devlemos.viewmodel.features.result.ResultActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ViewModelActivity::class.java)

        setupInputTextChangedListener()
        setupButtonClickListener()
        setupObservers()
    }

    fun setupObservers(){
        viewModel.param.observe(this, Observer {
            startActivity(ResultActivity.createIntent(this,it.toString()))
        })
    }

    private fun setupButtonClickListener() {
        val btnSend : Button = findViewById(R.id.btnSendValue)
        btnSend.setOnClickListener {
            viewModel.onUserSendForm()
        }
    }

    private fun setupInputTextChangedListener(){
        val inputValue : EditText = findViewById(R.id.inputValue)
        inputValue.addTextChangedListener() {
            viewModel.onUserChangedInput(it.toString())
        }
    }


}