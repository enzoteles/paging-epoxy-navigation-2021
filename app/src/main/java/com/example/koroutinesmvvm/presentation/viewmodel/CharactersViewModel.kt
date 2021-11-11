package com.example.koroutinesmvvm.presentation.viewmodel

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.koroutinesmvvm.common.Constants.PREFETCH_DISTANCE
import com.example.koroutinesmvvm.data.repository.CharacterRepositoryImpl
import com.example.koroutinesmvvm.domain.datasource.CharacterDataSourceFactory
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper

class CharactersViewModel: ViewModel() {

    private val repository = CharacterRepositoryImpl()
    private val pageListConfig:PagedList.Config = PagedList.Config.Builder()
        .setPageSize(PAGE_SIZE)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .build()
    private val dataSourceFactory = CharacterDataSourceFactory(viewModelScope, repository)
    val characterPageListLiveDate: LiveData<PagedList<GetCharacterByIdMapper>> = LivePagedListBuilder(dataSourceFactory, pageListConfig).build()

}