package com.example.gppassingdata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// Jeremy Lockhart
// GP - Passing Data Between Activities
// 02-14-2026
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add the icon to the Action Bar
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // get the text box and send message button
        val tb = findViewById<EditText>(R.id.txtEditMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            // get the text from the edit box
            val msg = tb.text.toString()

            // create an intent to send the message to the message activity
            val i = Intent(this, MessageActivity::class.java)
            i.putExtra("message", msg)
            startActivity(i)
        }
    }
}
