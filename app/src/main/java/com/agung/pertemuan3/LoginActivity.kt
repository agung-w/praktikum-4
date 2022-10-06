package com.agung.pertemuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.agung.pertemuan3.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (emailCheck(binding.txtEmail.text.toString()) && passwordCheck(binding.txtPassword.text.toString()) ){
                val intent= Intent(this@LoginActivity,MainActivity::class.java)
                intent.putExtra(Intent.EXTRA_TEXT,binding.txtEmail.text.toString())
                startActivity(intent)//explicit intent
                this.finish()
            }else {
                Snackbar.make(this, binding.button, resources.getString(R.string.msg_failed), Snackbar.LENGTH_LONG).show()
            }
        }

    }
    private fun emailCheck(email:String):Boolean{
        if (email.lowercase()=="agung@gmail.com") return true
        if (email.trim().isEmpty()){
            binding.txtEmail.error=resources.getString(R.string.email_missing)
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.txtEmail.error=resources.getString(R.string.invalid_type_email)
        }
        return false
    }

    private fun passwordCheck(password: String) : Boolean{
        if(password == "1972050"){
            return true
        }
        if(password.trim().isEmpty()){
            binding.txtPassword.error=resources.getString(R.string.password_missing)
        }
        return false
    }
}