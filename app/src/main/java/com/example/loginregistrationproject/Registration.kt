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
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //Back Button Functionality
        val backButton = findViewById<ImageView>(R.id.ivBackButton)
        val intent = Intent(this, MainActivity::class.java) //explicit intent

        backButton.setOnClickListener {
            startActivity(intent)
        }


        val registrationButton = findViewById<ExtendedFloatingActionButton>(R.id.btnSignUpButton)
        registrationButton.setOnClickListener {
            /*
            when button is clicked:
            - Verify the email and password is valid
            - Also verify the confirm password matches the password
             */

            //Registration check
            val registerEmail = findViewById<EditText>(R.id.etRegisterEmail)
            val registerPassword = findViewById<EditText>(R.id.etRegistrationPassword)
            val registerConfirmPassword = findViewById<EditText>(R.id.etRegistrationConfirmPassword)

            //Convert email, password and confirm password to strings
            val registerEmailString = registerEmail.text.toString()
            val registerPasswordString = registerPassword.text.toString()
            val registerConfirmPasswordString = registerConfirmPassword.text.toString()

            //Validate registration email and password
            var isValidRegistrationEmail =
                Patterns.EMAIL_ADDRESS.matcher(registerEmailString).matches() ?: false

            var passRegex =
                "^.*(?=.{8,})(?=.+[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).*\$"


            var isValidRegisterPassword =
                registerPasswordString.matches(passRegex.toRegex()) ?: false
            var isMatchingPasswordAndConfirmPassword =
                registerPasswordString == registerConfirmPasswordString ?: false //confirms if both password and confirm password matches



            if (isValidRegistrationEmail && isValidRegisterPassword && isMatchingPasswordAndConfirmPassword) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show()
            } else if (!isValidRegistrationEmail && isValidRegisterPassword && isMatchingPasswordAndConfirmPassword) {
                //invalid email only
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_LONG).show()

            } else if (!isValidRegistrationEmail && !isValidRegisterPassword && isMatchingPasswordAndConfirmPassword) {
                //invalid email and password only
                Toast.makeText(this, "Invalid Email and Password", Toast.LENGTH_LONG).show()
            } else if (!isValidRegistrationEmail && !isValidRegisterPassword && !isMatchingPasswordAndConfirmPassword) {
                //everything is invalid
                Toast.makeText(this, "Invalid Email and Password also passwords don't match", Toast.LENGTH_LONG
                ).show()

            } else if (isValidRegistrationEmail && isValidRegisterPassword && !isMatchingPasswordAndConfirmPassword) {
                //only passwords don't match
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show()

            } else if (isValidRegistrationEmail && !isValidRegisterPassword && isMatchingPasswordAndConfirmPassword) {
                //invalid password only
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show()

            }else if(isValidRegistrationEmail && !isValidRegisterPassword && !isMatchingPasswordAndConfirmPassword){
                //invalid password and passwords don't match
                Toast.makeText(this, "Invalid Password and passwords don't match", Toast.LENGTH_LONG).show()

            }
//
//            when(isValidRegistrationEmail && isValidRegisterPassword && isMatchingPasswordAndConfirmPassword){
//                //every entry is valid
//                true, true, true ->   Toast.makeText(this,"Registration Successful", Toast.LENGTH_LONG).show()
//
//                //email invalid, password invalid, confirm password valid
//                false,false, true -> Toast.makeText(this,"Email and password are invalid", Toast.LENGTH_LONG).show()
//
//                //every entry is invalid
//                false, false, false -> Toast.makeText(this,"Everything is invalid", Toast.LENGTH_LONG).show()
//
//                //email invalid, password valid, confirm password valid
//                false, true, true -> Toast.makeText(this,"Invalid email address", Toast.LENGTH_LONG).show()
//
//
//                //email valid, password invalid, confirm password valid
//                true, false, true -> Toast.makeText(this,"Invalid Password", Toast.LENGTH_LONG).show()
//
//
//                //email valid,password valid, confirm password invalid
//                true, true, false -> Toast.makeText(this,"The passwords don't match", Toast.LENGTH_LONG).show()
//
//
//            }
        }


    }
}