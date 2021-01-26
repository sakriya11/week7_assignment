package com.sakriya.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sakriya.week7.db.StudentDB
import com.sakriya.week7.entity.User

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.coroutineContext


class Registration : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etUserName : EditText
    private lateinit var etPassword : EditText
    private lateinit var etPass2 : EditText
    private lateinit var btnAdd : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etName = findViewById(R.id.etName)
        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        etPass2 = findViewById(R.id.etpass2)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {

            Register()
        }
    }

    private fun Register(){
        if (checkEmpty()){
            val fname = etName.text.toString()
            val username = etUserName.text.toString()
            val password = etPassword.text.toString()
            val conformPassword = etPass2.text.toString()

            if (password != conformPassword){
                etPassword.error = "Password did not match"
                etPassword.requestFocus()

            }
            else{

                val user = User (fname,username,password)
                CoroutineScope(Dispatchers.IO).launch{

                    StudentDB.getInstance(this@Registration).getUserDAO().registerUser(user)

                    //switching to main thread
                    withContext(Main){

                        Toast.makeText(this@Registration, "Saved", Toast.LENGTH_SHORT).show()
                    }


                }
            }

        }
    }




    private fun checkEmpty(): Boolean {
        var flag = true

        when {
            TextUtils.isEmpty(etName.text) -> {
                etName.error = "Enter your full name"
                etName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etUserName.text) -> {
                etUserName.error = "Enter your username"
                etUserName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPassword.error = "Enter your Password"
                etPassword.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etPass2.text) -> {
                etPass2.error = "Conform your password"
                etPass2.requestFocus()
                flag = false
            }

        }

        return flag
    }
}