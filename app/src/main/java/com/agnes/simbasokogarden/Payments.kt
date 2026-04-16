package com.agnes.simbasokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams

class Payments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Receive the extras data the product_name and product_cost
//        this data is passed via intent

        val productname= intent.getStringExtra("product_name")
        val productcost=intent.getIntExtra("product_cost",0)
        val productphoto=intent.getStringExtra("product_photo")

        val photo= findViewById<ImageView>(R.id.payments_photo)
        val product=findViewById<TextView>(R.id.txtProductName)
        val cost=findViewById<TextView>(R.id.txtProductCost)
        val phone=findViewById<EditText>(R.id.phone)
        val pay=findViewById<Button>(R.id.pay)


//        update textview with values passed via the intent

        product.text=productname
        cost.text="Ksh $productcost"

        Glide.with(this)
            .load(productphoto)
            .circleCrop()
            .into(photo)

        pay.setOnClickListener {

            val api="https://agnes.alwaysdata.net/api/mpesa_payment"
            val data= RequestParams()
            data.put("amount",productcost)
            data.put("phone",phone.text.toString())

            val helper= ApiHelper(applicationContext)
            helper.post(api,data)



        }
    }
}