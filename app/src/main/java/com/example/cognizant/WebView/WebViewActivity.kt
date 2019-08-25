package com.example.cognizant.WebView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.cognizant.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val navegador: WebView = findViewById(R.id.id_web)
        navegador.loadUrl("https://peoplesoft.cognizant.com/")
    }
}
