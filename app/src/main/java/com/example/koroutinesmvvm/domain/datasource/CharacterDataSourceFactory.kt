package com.example.koroutinesmvvm.domain.datasource

import androidx.paging.DataSource
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.repo.CharacterRepository
import kotlinx.coroutines.CoroutineScope

class CharacterDataSourceFactory(
    private val coroutineScope: CoroutineScope,
    private val repository: CharacterRepository
): DataSource.Factory<Int, GetCharacterByIdMapper>() {
    override fun create(): DataSource<Int, GetCharacterByIdMapper> {
        return CharacterDataSource(coroutineScope, repository)
    }
}