package com.example.cognizant.SplashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cognizant.ClassePrincipal.MainActivity
import com.example.cognizant.R
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val background = object: Thread() {
            override fun run() {
                try{
                    Thread.sleep(2000)

                    val intecaoSplash = Intent(baseContext, MainActivity::class.java)
                    startActivity(intecaoSplash)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}