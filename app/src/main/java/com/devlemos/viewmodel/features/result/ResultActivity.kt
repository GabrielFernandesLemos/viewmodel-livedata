package com.devlemos.viewmodel.features.result

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.devlemos.viewmodel.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setInputValues()
    }

    companion object {
        var receivedValue = ""
        fun createIntent(context: Context, value : String) : Intent{
            return Intent(context, ResultActivity::class.java).apply {
                receivedValue = value
            }
        }
    }

    fun setInputValues(){
        var receivedText : TextView = findViewById(R.id.inputChoice)
        receivedText.text = receivedValue
    }


}