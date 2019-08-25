package com.example.cognizant.ClassePrincipal

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cognizant.Alarme.Alarme
import com.example.cognizant.R
import com.example.cognizant.WebView.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_buttonWeb.setOnClickListener() {
            val intencao = Intent(this, WebViewActivity::class.java)
            startActivity(intencao)
        }

        id_botaoalarme.setOnClickListener(){
            val intencaoAlarme = Intent(this,Alarme::class.java)
            startActivity(intencaoAlarme)
        }

        val myConstraint: ConstraintLayout = findViewById(R.id.layout)
        val myAnimation: AnimationDrawable = myConstraint.background as AnimationDrawable
        myAnimation.setEnterFadeDuration(2000)
        myAnimation.setExitFadeDuration(4000)
        myAnimation.start()
    }
}
