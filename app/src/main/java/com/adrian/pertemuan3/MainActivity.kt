package com.adrian.pertemuan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adrian.pertemuan3.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun login (email: String, password: String){
            if (email == "adrianoctavius0@gmail.com" && password == "1972008"){
                Toast.makeText(this, resources.getString(R.string.msg_success), Toast.LENGTH_SHORT).show()
            }else {
                Snackbar.make(this, binding.button, resources.getString(R.string.msg_failed), Snackbar.LENGTH_LONG).show()
            }
        }

        binding.button.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()
            login(email, password)
        }
    }
}