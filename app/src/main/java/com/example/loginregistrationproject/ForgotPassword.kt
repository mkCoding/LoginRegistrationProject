package com.example.loginregistrationproject

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<ImageView>(R.id.ivBackButtonForgotPass)
        val intent = Intent(this, MainActivity::class.java)
        backButton.setOnClickListener {
            startActivity(intent)
        }

        val editTextEmail = findViewById<EditText>(R.id.etEnterEmail)
        val sendEmailButton = findViewById<ExtendedFloatingActionButton>(R.id.btnForgotPassword)
        sendEmailButton.setOnClickListener {
            val pattern = Patterns.EMAIL_ADDRESS

            if(pattern.matcher(editTextEmail.text).matches()){
                Toast.makeText(this,"Confirmation Email Sent!",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Invalid Email. Try again or Register for an account",Toast.LENGTH_LONG).show()
            }
        }

    }
}