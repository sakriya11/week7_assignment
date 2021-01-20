package com.sakriya.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.sakriya.week7.model.User


class Registration : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etUserName : EditText
    private lateinit var etPassword : EditText
    private lateinit var etPass2 : EditText
    private lateinit var btnAdd : Button

    private lateinit var userList :ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etName = findViewById(R.id.etName)
        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        etPass2 = findViewById(R.id.etpass2)
        btnAdd = findViewById(R.id.btnAdd)
    }


    private fun addUser(){
        btnAdd.setOnClickListener {
            if(checkEmpty() && etPassword==etPass2){

            var user = User (etName.text.toString(), etUserName.text.toString(),etPassword.text.toString())
                userList.add(user)
                val intent = Intent(this,Login::class.java)
                intent.putExtra("userList",userList)
                startActivity(intent)

            }else
                return@setOnClickListener



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