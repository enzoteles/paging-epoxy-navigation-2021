package com.example.koroutinesmvvm.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.databinding.FragmentCharacterListBinding
import com.example.koroutinesmvvm.presentation.controller.list.CharacterListEpoxyController
import com.example.koroutinesmvvm.presentation.viewmodel.list.CharactersViewModel


class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    private val epoxyController = CharacterListEpoxyController(::onCharacterSelected)

    private val viewModel : CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    private  var _binding: FragmentCharacterListBinding?= null
    private  val binding: FragmentCharacterListBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characterPageListLiveDate.observe(viewLifecycleOwner){ pagedList ->
            epoxyController.submitList(pagedList)
        }
        binding.characterListRV.setControllerAndBuildModels(epoxyController)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onCharacterSelected(characterId: Int){
        val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(characterId)
        findNavController().navigate(action)
    }
}