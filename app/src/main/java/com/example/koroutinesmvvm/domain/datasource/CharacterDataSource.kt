package com.example.koroutinesmvvm.domain.datasource

import androidx.paging.PageKeyedDataSource
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.repo.list.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class CharacterDataSource(
    private val coroutineScope: CoroutineScope,
    private val repository: CharacterRepository
) : PageKeyedDataSource<Int, GetCharacterByIdMapper>() {



    private fun getPageIndexFormNex(next:String?): Int?{
        return next?.split("?page=")?.get(1)?.toInt()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GetCharacterByIdMapper>
    ) {
        coroutineScope.launch {
            val page = repository.getCharacterList(1)
            if(page == null){
                callback.onResult(emptyList(), null, null)
                return@launch
            }
            callback.onResult(page?.results!!, null, getPageIndexFormNex(page?.info.next))
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdMapper>
    ) {
        coroutineScope.launch {
            val page = repository.getCharacterList(params.key)
            if(page == null){
                callback.onResult(emptyList(), null)
                return@launch
            }
            callback.onResult(page?.results!!, getPageIndexFormNex(page?.info.next))
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdMapper>
    ) {
        //nothing to do
    }


}