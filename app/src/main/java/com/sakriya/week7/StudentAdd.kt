package com.sakriya.week7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.sakriya.week7.model.Student
import com.sakriya.week7.lstStudent
class StudentAdd : AppCompatActivity() {

    private lateinit var etFname: EditText
    private lateinit var etAge: EditText
    private lateinit var rgBtn: RadioGroup
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button
//    private var lstStudent = ArrayList<Student>()
    var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_add)
        etFname = findViewById(R.id.etFname)
        etAge = findViewById(R.id.etAge)
        rgBtn = findViewById(R.id.rgBtn)
        etAddress = findViewById(R.id.etAddress)
        btnSave = findViewById(R.id.btnSave)
        rgBtn.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.rbMale -> {
                    gender = "Male"
                }
                R.id.rbFemale -> {
                    gender = "Female"
                }
                R.id.rbOthers -> {
                    gender = "Others"
                }
            }
        }
        rgBtn.check(R.id.rbMale)

        btnSave.setOnClickListener {
            addUser()
        }

    }

    private fun addUser() {


        if (checkEmpty()) {
            val user = etFname.text.toString()
            val age = etAge.text.toString().toInt()
            val address = etAddress.text.toString()
            lstStudent.add(Student(user, age, address))
            Toast.makeText(this, "Data is added", Toast.LENGTH_SHORT).show()
        }


    }

    private fun checkEmpty(): Boolean {

        var flag = true

        when {
            TextUtils.isEmpty(etFname.text) -> {
                etFname.error = "Enter your name"
                etFname.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "Enter age"
                etAge.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "Enter your address"
                etAddress.requestFocus()
                flag = false
            }

        }

        return flag
    }
}