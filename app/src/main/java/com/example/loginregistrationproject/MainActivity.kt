package com.example.loginregistrationproject

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        //Login check
        val email = findViewById<EditText>(R.id.etEmailAddress)
        val password = findViewById<EditText>(R.id.etPassword)
        findViewById<ExtendedFloatingActionButton>(R.id.btnLogin).setOnClickListener {
            // write logic to handle the button
            val submittedEmail = email.text.toString()
            val submittedPassword = password.text.toString()

            /*
             TODO: Create the logic to verify user login details,
              EMAIL should be valid,
              Password must have at least 8 length including small/capital letters with digit and special characters
             */
            var isValidEmail = false //flag to determine if email is valid or not
            var isValidPassword = false //flag to determine if password is valid or not

            val pattern = Patterns.EMAIL_ADDRESS //a pattern object which references Email address pattern

            //assign true/false after email and password is validated
            isValidEmail = pattern.matcher(submittedEmail).matches()?: false //validate email
            isValidPassword = submittedPassword.matches("^.*(?=.{8,})(?=.+[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&+=()]).*\$".toRegex()) //validate password

            /*
            Created when conditional statement
            - if both email and password is true Print Login Successful
            - if both email and password is false Show Message "Login Unsuccessful
             */
            when (Pair(isValidEmail, isValidPassword)){
                Pair(true, true) -> Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_SHORT).show() //both username and password is correct
                else -> Toast.makeText(applicationContext,"Login Unsuccessful",Toast.LENGTH_SHORT).show() //username or password is incorrect
            }
        }

        //Add forgot password link functionality
        val intent2 = Intent(this,ForgotPassword::class.java)
        val forgotPassword = findViewById<TextView>(R.id.tvForgotPasswordLink)
        forgotPassword.setOnClickListener {
            startActivity(intent2) //will navigate to ForgotPassword screen
        }

        //Add sign up link functionality
        val signUpLink = findViewById<TextView>(R.id.tvSignUpLink)
        val intent = Intent(this, Registration::class.java) //explicit intent

        //when signup is clicked navigate to Registration Activity
        signUpLink.setOnClickListener {

            Toast.makeText(this,"Link clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}