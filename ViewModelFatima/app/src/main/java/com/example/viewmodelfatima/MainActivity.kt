package com.example.viewmodelfatima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelfatima.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.textViewCounter.text = viewModel.getInitialCounter().toString()

        binding.btnIncrement.setOnClickListener{
            binding.textViewCounter.text = viewModel.getUpdatedCounter().toString()
        }


    }
}