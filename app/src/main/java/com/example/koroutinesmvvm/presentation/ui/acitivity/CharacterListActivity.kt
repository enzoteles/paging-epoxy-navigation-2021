package com.example.koroutinesmvvm.presentation.ui.acitivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.databinding.ActivityCharacterListBinding
import com.example.koroutinesmvvm.presentation.controller.list.CharacterListEpoxyController
import com.example.koroutinesmvvm.presentation.viewmodel.list.CharactersViewModel

class CharacterListActivity: AppCompatActivity(R.layout.activity_character_list) {

    private val epoxyController = CharacterListEpoxyController()

    private val viewModel : CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCharacterListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.characterPageListLiveDate.observe(this){ pagedList ->
            epoxyController.submitList(pagedList)
        }
        binding.characterListRV.setControllerAndBuildModels(epoxyController)
    }
}