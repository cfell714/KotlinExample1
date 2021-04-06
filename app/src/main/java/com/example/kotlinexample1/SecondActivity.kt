package com.example.kotlinexample1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinexample1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){

    private lateinit var binding:ActivitySecondBinding
    private lateinit var textViewGreeting:TextView
    private lateinit var buttonHistory:Button
    private final val baseUrl = "https://www.behindthename.com/name/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewGreeting = binding.textViewGreeting

        val message = intent.getStringExtra("name")
        textViewGreeting.text = "Hello, " + message

        buttonHistory = binding.buttonHistory
        // set the text of this button to be history about NAME
        buttonHistory.text = "History about " + message

        buttonHistory.setOnClickListener{
            if (message != null) {
                launchBrowser(message)
            }
        }

    }

    // when the button is clicked
    // send an implicit intent with the name passed through intent
    // https://www.behindthename.com/name/NAME

    private fun launchBrowser(name:String){
        // Uri to parse the actual url
        // start an activity with action view
        val queryURL:Uri = Uri.parse("${baseUrl}${name}")
        // template string
        // "${}"
        val intent = Intent(Intent.ACTION_VIEW, queryURL)
        startActivity(intent)


    }


}