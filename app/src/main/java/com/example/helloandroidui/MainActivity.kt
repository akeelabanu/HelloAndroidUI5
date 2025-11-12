package com.example.helloandroidui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Optional: edge-to-edge if you want
        enableEdgeToEdge()

        // set layout
        setContentView(R.layout.activity_main)

        // padding for system bars (you had this, keep it)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // find views AFTER setContentView
        val nameInput = findViewById<TextInputEditText>(R.id.nameInput)
        val clickBtn = findViewById<MaterialButton>(R.id.clickMeButton)
        val openSecond = findViewById<MaterialButton>(R.id.openSecondButton)

        // Click listener for Click Me button
        clickBtn?.setOnClickListener {
            val name = nameInput?.text?.toString()?.trim()
            if (!name.isNullOrEmpty()) {
                Toast.makeText(this, "Welcome, $name!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Welcome to Android Development!", Toast.LENGTH_SHORT).show()
            }
        }

        // Click listener to open SecondActivity
        openSecond?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_name", nameInput?.text?.toString())
            startActivity(intent)
        }
    }
}
