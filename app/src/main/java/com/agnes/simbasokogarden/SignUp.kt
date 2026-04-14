package com.agnes.simbasokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUp=findViewById<TextView>(R.id.signup_link)

        signUp.setOnClickListener {

            val signUpLink= Intent(applicationContext, SignIn ::class.java)
            startActivity(signUpLink)
        }


        val username=findViewById<EditText>(R.id.username)
        val email=findViewById<EditText>(R.id.email)
        val phone=findViewById<EditText>(R.id.phone)
        val password=findViewById<EditText>(R.id.password)
        val signup=findViewById<Button>(R.id.signup)

        signup.setOnClickListener {

            val api="https://agnes.alwaysdata.net/api/signup"

            val data = RequestParams()
            data.put("username", username.text.toString())
            data.put("email", email.text.toString())
            data.put("phone",phone.text.toString())
            data.put("password",password.text.toString().trim())


            val helper= ApiHelper(applicationContext)
            helper.post(api,data)



        }
    }
}