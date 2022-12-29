package com.example.logindesign

import android.app.Application
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.logindesign.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
        binding.btnlogin.setOnClickListener{
            var kayitlikullanici=preferences.getString("kullanici","")
            var Kayparola=preferences.getString("parola","")
            var loginpanel=binding.giriskullaniciadi.text.toString()
            var parolapanel=binding.girisparola.text.toString()

            if ((kayitlikullanici==loginpanel) && (Kayparola==parolapanel))
                {
                    intent= Intent(applicationContext,Welcome::class.java)
                    startActivity(intent)
                }
            else
            {
               Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı!",Toast.LENGTH_LONG).show()
            }



        }
        binding.btnregister.setOnClickListener{
            intent= Intent(applicationContext,Register::class.java)
            startActivity(intent)
        }
    }

}