package com.example.tsquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    fun init () {
       var button : Button = findViewById(R.id.button3)
        var intent : Intent = Intent(this , MainActivity2::class.java)
        button.setOnClickListener {
            startActivity(intent)
            finish()
        }
    }

}


