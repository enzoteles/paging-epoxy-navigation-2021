package com.example.koroutinesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.koroutinesmvvm.databinding.ActivityMainBinding
import com.example.koroutinesmvvm.presentation.controller.CharacterDetailsEpoxyController
import com.example.koroutinesmvvm.presentation.viewmodel.ShareViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    //instanciando o view model
    val viewModel: ShareViewModel by lazy {
        ViewModelProvider(this).get(ShareViewModel::class.java)
    }

    private val epoxyController = CharacterDetailsEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //usando o método do viewmodel
        viewModel.characterByIdMapperLiveData.observe(this) { response ->
            epoxyController.characterResponse = response

            if (response == null) {
                Toast.makeText(
                    this@MainActivity,
                    "Unsucceful network call",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }
        }

        viewModel.refreshCharacter(10)
        binding.epoxyRV.setControllerAndBuildModels(epoxyController)

    }
}