package com.agnes.simbasokogarden

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class About : AppCompatActivity() {

//    declare a tts variable

    lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        find the view and button

        val textinfo = findViewById<TextView>(R.id.textView)
        val speak = findViewById<EditText>(R.id.inputText)
        val button = findViewById<Button>(R.id.speakButton)

//        initialize text to speech(create a tts object checks if tts is available in set language)
        tts = TextToSpeech(this) {

            if (it == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
            }
        }
//        set button listener

        button.setOnClickListener {
            val textt = speak.text.toString()
            tts.speak(textt, TextToSpeech.QUEUE_FLUSH, null, null)


        }

    }



        //Stop the tts from speaking when app is closed/destroyed/killed
        override fun onDestroy() {
            tts.stop() //stops tts
            tts.shutdown()
            super.onDestroy()
        }


    }
