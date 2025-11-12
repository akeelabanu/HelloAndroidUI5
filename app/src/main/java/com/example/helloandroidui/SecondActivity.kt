package com.example.helloandroidui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tv = findViewById<TextView>(R.id.secondText)
        val name = intent.getStringExtra("user_name")
        if (!name.isNullOrEmpty()) {
            tv.text = "Hello, $name! This is Second Activity."
        }
    }
}
