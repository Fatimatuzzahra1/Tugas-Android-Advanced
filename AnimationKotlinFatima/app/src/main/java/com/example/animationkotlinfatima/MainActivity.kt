package com.example.animationkotlinfatima

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnAnimasi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAnimasi = findViewById(R.id.btnAnimasi)
        btnAnimasi.setOnClickListener{
            customDialog()

        }
    }

    private fun customDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.custom_dialog)

        val btnTutup = dialog.findViewById<Button>(R.id.btnTutup)
        btnTutup.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}