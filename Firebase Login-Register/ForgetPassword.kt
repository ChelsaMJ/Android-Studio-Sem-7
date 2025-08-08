package com.example.firebaseauth1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password)


        auth = FirebaseAuth.getInstance()
        emailEditText = findViewById(R.id.emailEditText)
        resetButton = findViewById(R.id.resetButton)


        resetButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty()){
                emailEditText.error = "Please enter 🫵 email"
                return@setOnClickListener
            }
            auth.sendPasswordResetEmail(email).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Password reset email sent!",
                        Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this, "Error: ${task.exception?.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}