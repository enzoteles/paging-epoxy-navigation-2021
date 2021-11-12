package com.example.koroutinesmvvm.presentation.ui.acitivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.databinding.ActivityNavGraphBinding

class NavGraphActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNavGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}