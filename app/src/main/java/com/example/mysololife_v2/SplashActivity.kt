package com.example.mysololife_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.mysololife_v2.auth.IntroActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = Firebase.auth

        if(auth.currentUser?.uid == null) {
            Log.d("Splash Activity","null")
            Handler().postDelayed({
                startActivity(Intent(this,IntroActivity::class.java))
                finish()
            },3000)
        } else {
            Log.d("Splash Activity","not null")
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)
        }
//        Handler().postDelayed({
//            startActivity(Intent(this,IntroActivity::class.java))
//            finish()
//        },3000)
    }
}