package com.example.gppassingdata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Jeremy Lockhart
// GP - Passing Data Between Activities
// 02-14-2026
class MessageActivity : AppCompatActivity() {

    lateinit var txtMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        // add the icon to the Action Bar
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // get the text view to update with the message received
        txtMessage = findViewById<TextView>(R.id.txtMessage)

        // set the text view's text property to the message received
        txtMessage.text = intent.extras?.getString("message") ?: "No message found"
    }
}
