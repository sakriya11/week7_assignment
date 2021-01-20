package com.sakriya.week7

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Display : AppCompatActivity() {
//    private var lstStudent = ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        recyclerView = findViewById(R.id.recyclerView)
//        loadStudents()
        val adapter = StudentAdapter(lstStudent, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

//    private fun loadStudents() {
//     lstStudent.add(
//         Student(
//             "Sakriya Khadka",
//             21,
//             "Kathmandu",
//             "Male"
//         )
//     )
//    }
}