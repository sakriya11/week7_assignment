package com.sakriya.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnAddStudent : Button
    private lateinit var btnViewStudent : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddStudent=findViewById(R.id.btnAddStudent)
        btnViewStudent=findViewById(R.id.btnViewStudent)

        btnViewStudent.setOnClickListener {
            val intent = Intent(this,Display::class.java)
            startActivity(intent)
        }

        btnAddStudent.setOnClickListener {
            val intent = Intent(this,StudentAdd::class.java)
            startActivity(intent)
        }
    }
}