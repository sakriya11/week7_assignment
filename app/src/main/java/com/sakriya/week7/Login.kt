package com.sakriya.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sakriya.week7.db.StudentDB
import com.sakriya.week7.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {


    private lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val intent = Intent(this, Registration::class.java)

            startActivity(intent)
        }



        btnLogin.setOnClickListener {
            login()
        }





    }

    private fun login(){
        val username = etUser.text.toString()
        val password = etPass.text.toString()

        var user : User? = null

        CoroutineScope(Dispatchers.IO).launch {
            user = StudentDB.getInstance(this@Login)
                .getUserDAO().checkUser(username,password)

            if (user == null){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@Login, "invalid", Toast.LENGTH_SHORT).show()
                }
            }else{
                startActivity(Intent(this@Login,MainActivity::class.java))
            }

        }
    }
}