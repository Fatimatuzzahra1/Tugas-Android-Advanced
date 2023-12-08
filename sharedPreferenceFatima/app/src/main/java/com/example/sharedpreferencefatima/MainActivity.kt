package com.example.sharedpreferencefatima

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var profilePreference: ProfilePreference
    lateinit var tvNama: TextView
    lateinit var tvUmur: TextView
    lateinit var tvJeniskelamin: TextView
    lateinit var btnEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profilePreference = ProfilePreference(this)

        tvNama = findViewById(R.id.tvNama)
        tvUmur = findViewById(R.id.tvUmur)
        tvJeniskelamin = findViewById(R.id.tvJeniskelamin)
        btnEdit = findViewById(R.id.btnEdit)

        if(profilePreference.preference.contains(ProfilePreference.NAMA)){
            val profile = profilePreference.getProfile()
            tvNama.text = profile.nama
            tvUmur.text = profile.umur.toString()
            tvJeniskelamin.text = profile.jeniskelamin
        }

        btnEdit.setOnClickListener{
            Intent(this, FormActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}