package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.isDigitsOnly
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var password: EditText
    lateinit var repassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.EmailEditText)
        phone = findViewById(R.id.phoneEditText)
        password = findViewById(R.id.passwordEditText)
        repassword = findViewById(R.id.repasswordEditText)
    }

    fun signup(view: android.view.View) {
        val emailText = email.text.toString()
        val phoneText = phone.text.toString()
        val passwordText = password.text.toString()
        val rePasswordText = repassword.text.toString()
        if (emailText.isNotBlank() &&
            passwordText.isNotBlank() &&
            phoneText.isNotBlank() &&
            rePasswordText.isNotBlank()
        ) {
            if (passwordText == rePasswordText) {
                    AlertDialog.Builder(this)
                        .setTitle("Поздравляем")
                        .setMessage("Вы успешно зарегистрировались")
                        .setPositiveButton("ОК",{_,_ ->
                            val intent = Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                        } )
                        .create()
                        .show()

                }

             else {
            Snackbar.make(view, "пароли не равны", Snackbar.LENGTH_LONG).show()
             }
         }
         else{
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
        }
    }
}