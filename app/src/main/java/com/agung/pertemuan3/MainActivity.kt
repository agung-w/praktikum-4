package com.agung.pertemuan3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agung.pertemuan3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.openWebButton.setOnClickListener{
            val webUri= Uri.parse("https://it.maranatha.edu")
            val intent=Intent(Intent.ACTION_VIEW,webUri)
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        binding.dialButton.setOnClickListener {
            val phoneNumber =Uri.parse("tel:+628122018185")
            val dialIntent=Intent(Intent.ACTION_DIAL,phoneNumber)
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(dialIntent)
            }


        }

    }

    override fun onStart() {
        super.onStart()
        val email=intent.getStringExtra(Intent.EXTRA_TEXT)
        binding.outputTV.text=email
    }

}