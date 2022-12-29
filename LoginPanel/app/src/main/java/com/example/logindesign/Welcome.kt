package com.example.logindesign

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logindesign.databinding.ActivityMainBinding
import com.example.logindesign.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
        var userlogin=preferences.getString("kullanici","")
        var userparola=preferences.getString("parola","")
        binding.kullanicibilgisi.text="Kullanıcı Adı =" +userlogin.toString()
        binding.kullaniciparola.text="Parola ="+userparola.toString()

        binding.btnexcel.setOnClickListener{
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
    }
}