package com.example.firebaseauth1

import com.example.firebaseauth1.User
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DataBaseMain : AppCompatActivity() {

    private lateinit var etUserId: EditText
    private lateinit var etUserName: EditText
    private lateinit var etUserEmail: EditText
    private lateinit var btnCreate: Button
    private lateinit var btnRead: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.database_main)

        FirebaseApp.initializeApp(this)

        etUserId = findViewById(R.id.etUserId)
        etUserName = findViewById(R.id.etUserName)
        etUserEmail = findViewById(R.id.etUserEmail)
        btnCreate = findViewById(R.id.btnCreate)
        btnRead = findViewById(R.id.btnRead)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        database = FirebaseDatabase.getInstance().getReference("Users")

        // CREATE
        btnCreate.setOnClickListener {
            val id = etUserId.text.toString()
            val name = etUserName.text.toString()
            val email = etUserEmail.text.toString()

            if (id.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty()) {
                val user = User(id, name, email)
                database.child(id).setValue(user)
                    .addOnSuccessListener {
                        Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Create", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // READ
        btnRead.setOnClickListener {
            val id = etUserId.text.toString()
            if (id.isNotEmpty()) {
                database.child(id).get()
                    .addOnSuccessListener {
                        if (it.exists()) {
                            val name = it.child("name").value
                            val email = it.child("email").value
                            etUserName.setText(name.toString())
                            etUserEmail.setText(email.toString())
                            Toast.makeText(this, "User Found", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "User Not Found", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Read", Toast.LENGTH_SHORT).show()
                    }
            } else {
                etUserId.error = "User ID required"
            }
        }

        // UPDATE
        btnUpdate.setOnClickListener {
            val userId = etUserId.text.toString()
            val newName = etUserName.text.toString()
            val newEmail = etUserEmail.text.toString()

            if (userId.isNotEmpty() && (newName.isNotEmpty() || newEmail.isNotEmpty())) {
                val updates = mutableMapOf<String, Any>()
                if (newName.isNotEmpty()) updates["name"] = newName
                if (newEmail.isNotEmpty()) updates["email"] = newEmail

                database.child(userId).updateChildren(updates)
                    .addOnSuccessListener {
                        Toast.makeText(this, "User Updated", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "User ID and at least one field to update are required", Toast.LENGTH_SHORT).show()
            }
        }

        // DELETE
        btnDelete.setOnClickListener {
            val userId = etUserId.text.toString()
            if (userId.isNotEmpty()) {
                database.child(userId).removeValue()
                    .addOnSuccessListener {
                        etUserName.setText("")
                        etUserEmail.setText("")
                        Toast.makeText(this, "User Deleted", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Delete", Toast.LENGTH_SHORT).show()
                    }
            } else {
                etUserId.error = "User ID required"
            }
        }
    }
}