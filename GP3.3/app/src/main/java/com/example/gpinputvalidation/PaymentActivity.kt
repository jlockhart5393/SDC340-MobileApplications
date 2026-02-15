package com.example.gpinputvalidation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Jeremy Lockhart
// GP - Input Validation & Data Storage
// 02-15-2026
class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // add the icon to the Action Bar
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // get the UI controls
        val monthlyPayment = findViewById<TextView>(R.id.txtPayment)
        val img = findViewById<ImageView>(R.id.imgYears)

        // get the user entries stored in the shared preferences file
        val sharedPref = getSharedPreferences("User_Values", MODE_PRIVATE)
        val yearChoice = sharedPref.getString("selected_year", "not found")
        val loanAmt = sharedPref.getInt("loan_amount", 0)
        val intRate = sharedPref.getFloat("interest_rate", 0.0F)

        // convert the year choice to a value & set the correct image
        val choiceArr = resources.getStringArray(R.array.strarr_yrs)
        var numYrs = 0

        if (yearChoice == choiceArr[0]) {
            numYrs = 3
            img.setImageResource(R.drawable.img_three)
        } else if (yearChoice == choiceArr[1]) {
            numYrs = 4
            img.setImageResource(R.drawable.img_four)
        } else if (yearChoice == choiceArr[2]) {
            numYrs = 5
            img.setImageResource(R.drawable.img_five)
        }

        // calculate the payment & set the text
        val payment = (loanAmt * (1 + (intRate * numYrs))) / (12 * numYrs)
        val txtPayment = String.format("%.2f", payment)
        monthlyPayment.text = "Monthly Payment: $$txtPayment"
    }
}
