package com.example.mysololife_v2.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.example.mysololife_v2.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)
        val getUrl = intent.getStringExtra("url")

        val webview : WebView = findViewById(R.id.webView)
        webview.loadUrl(getUrl.toString())
    }
}