package com.example.koroutinesmvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koroutinesmvvm.data.repository.ShareRepositoryImpl
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import kotlinx.coroutines.launch

class ShareViewModel: ViewModel() {

    private val repository = ShareRepositoryImpl()

    //usando a estratégia de encapsulamento
    // aqui estou usando o mapper GetCharacterById ao invés do GetCharacterByIdDTO
    private val _characterByIdLiveData = MutableLiveData<GetCharacterByIdMapper?>()
    val characterByIdMapperLiveData: LiveData<GetCharacterByIdMapper?> = _characterByIdLiveData

    fun refreshCharacter(characterId: Int){
        //usando o scope do coroutines
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)
            _characterByIdLiveData.postValue(response)
        }
    }

}