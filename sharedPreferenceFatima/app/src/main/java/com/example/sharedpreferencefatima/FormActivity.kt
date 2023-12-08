package com.example.sharedpreferencefatima

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FormActivity : AppCompatActivity() {

    lateinit var profilePreference: ProfilePreference

    lateinit var etNama : EditText
    lateinit var etUmur : EditText
    lateinit var etJeniskelamin : EditText
    lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        profilePreference = ProfilePreference(this)

        btnSave = findViewById(R.id.btnSave)
        etNama = findViewById(R.id.etNama)
        etUmur = findViewById(R.id.etUmur)
        etJeniskelamin = findViewById(R.id.etJeniskelamin)

        if(profilePreference.preference.contains(ProfilePreference.NAMA)){
            val profile = profilePreference.getProfile()
            etNama.setText(profile.nama)
            profile.umur?.let{ etUmur.setText(it.toString())}
            etJeniskelamin.setText(profile.jeniskelamin)
        }

        btnSave.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val umur = etUmur.text.toString().trim()
            val jeniskelamin = etJeniskelamin.text.toString().trim()

            val profile = Profile(
                nama,
                umur.toInt(),
                jeniskelamin
            )

            saveToPref(profile)
        }
    }

    private fun saveToPref(profile: Profile){
        profilePreference.setProfile(profile)
        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
        Intent(this, MainActivity::class.java).also{
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}