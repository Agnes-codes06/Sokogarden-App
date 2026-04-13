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

class SignIn : AppCompatActivity() {
//    signin:https://agnes.alwaysdata.net/api/signin
//        signup:https://agnes.alwaysdata.net/api/signup
//        mpesa:https://agnes.alwaysdata.net/api/mpesa_payment
//        products:https://agnes.alwaysdata.net/api/getproductdetails



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signin=findViewById<TextView>(R.id.signin_link)

        signin.setOnClickListener {

            val signInlink= Intent(applicationContext, SignUp ::class.java)
            startActivity(signInlink)



        }

        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val signinbutton=findViewById<Button>(R.id.sign)

        signinbutton.setOnClickListener {

            val api="https://agnes.alwaysdata.net/api/signin"

//            request param is a container used to collect user details its like form datea in js

            val data = RequestParams()

            data.put("email",email.text.toString())
            data.put("password",password.text.toString().trim())


//            Api helper it delivers our data to the api
            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)






        }



    }
}