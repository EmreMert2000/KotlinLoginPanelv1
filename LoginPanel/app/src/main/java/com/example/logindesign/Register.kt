package com.example.logindesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logindesign.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnkaydet.setOnClickListener{
            var kullanicibilgisi=binding.Kayitkullaniciadi.text.toString()
            var kullaniciparola=binding.Kayitparola.text.toString()
            var sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor=sharedPreferences.edit()

            editor.putString("kullanici","$kullanicibilgisi").apply()
            editor.putString("parola","$kullaniciparola").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.Kayitkullaniciadi.text.clear()
            binding.Kayitparola.text.clear()
        }
        binding.btncome.setOnClickListener{
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}