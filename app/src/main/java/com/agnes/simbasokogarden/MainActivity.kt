package com.agnes.simbasokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signup=findViewById<Button>(R.id.signup)
        signup.setOnClickListener {

            val signupIntent= Intent(applicationContext, SignUp::class.java)
            startActivity(signupIntent)


        }

        val sign=findViewById<Button>(R.id.sign)
        sign.setOnClickListener {
            val signIntent= Intent(applicationContext, SignIn ::class.java)
            startActivity(signIntent)


        }

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        val api="https://agnes.alwaysdata.net/api/getproductdetails"

        val helper= ApiHelper(applicationContext)
        helper.loadProducts(api,recyclerView,progressbar)


    }



}