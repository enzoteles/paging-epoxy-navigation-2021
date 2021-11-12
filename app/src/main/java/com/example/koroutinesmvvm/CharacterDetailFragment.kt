package com.example.koroutinesmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.koroutinesmvvm.databinding.FragmentCharacterDetailBinding
import com.example.koroutinesmvvm.presentation.controller.detail.CharacterDetailsEpoxyController
import com.example.koroutinesmvvm.presentation.viewmodel.detail.ShareViewModel

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val epoxyController = CharacterDetailsEpoxyController()
    //instanciando o view model
    val viewModel: ShareViewModel by lazy {
        ViewModelProvider(this).get(ShareViewModel::class.java)
    }

    val safeArgs: CharacterDetailFragmentArgs by navArgs()

    private  var _binding: FragmentCharacterDetailBinding?= null
    private  val binding: FragmentCharacterDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //usando o método do viewmodel
        viewModel.characterByIdMapperLiveData.observe(viewLifecycleOwner) { response ->
            epoxyController.characterResponse = response

            if (response == null) {
                Toast.makeText(
                    requireContext(),
                    "Unsucceful network call",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }
        }

        val id = safeArgs.characterId
        viewModel.refreshCharacter(id)
        binding.epoxyRV.setControllerAndBuildModels(epoxyController)
    }
}