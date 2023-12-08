package com.example.sharedpreferencefatima

import android.content.Context
import android.content.Context.MODE_PRIVATE

class ProfilePreference (context : Context) {
    companion object{
        const val SP_NAMA = "profile_preference"
        const val NAMA = "nama"
        const val UMUR = "umur"
        const val JENISKELAMIN = "jenis kelamin"
    }

    val preference = context.getSharedPreferences(SP_NAMA, MODE_PRIVATE)

    fun setProfile(profile: Profile){
        val prefEditor = preference.edit()
        prefEditor.putString(NAMA, profile.nama)
        profile.umur?.let { prefEditor.putInt(UMUR, it)}
        prefEditor.putString(JENISKELAMIN, profile.jeniskelamin)
        prefEditor.apply()
    }

    fun getProfile(): Profile{
        val profile = Profile()
        profile.nama = preference.getString(NAMA, "")
        profile.umur = preference.getInt(UMUR, 0)
        profile.jeniskelamin = preference.getString(JENISKELAMIN, "")
        return profile
    }

}