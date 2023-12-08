package com.example.viewmodelfatima

import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    private var counter = 0

    fun getInitialCounter(): Int{
        return counter
    }

    fun getUpdatedCounter(): Int{
        return ++counter
    }

}