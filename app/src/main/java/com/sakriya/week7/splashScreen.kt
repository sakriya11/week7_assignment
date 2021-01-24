package com.sakriya.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //main and IO

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            startActivity(
                Intent(
                    this@splashScreen,
                    Login::class.java
                )
            )
            finish()
        }
    }
}