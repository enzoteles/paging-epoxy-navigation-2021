package com.example.koroutinesmvvm.presentation.controller.list

import androidx.navigation.NavController
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.common.LoadingEpoxyModel
import com.example.koroutinesmvvm.databinding.ActivityCharacterListItemBinding
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.presentation.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class CharacterListEpoxyController(
    val onCharacterSelected: (Int) -> Unit
): PagedListEpoxyController<GetCharacterByIdMapper>() {

    override fun buildItemModel(
        currentPosition: Int,
        item: GetCharacterByIdMapper?
    ): EpoxyModel<*> {
        return CharacterGridItemEpoxyModel(characterId = item?.id ?: 0, imageUrl = item?.image ?: "", name = item?.name ?: "", onCharacterSelected = onCharacterSelected).id(item?.id)
    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        if(models.isEmpty()){
            LoadingEpoxyModel().id("loading").addTo(this)
            return
        }
        super.addModels(models)
    }

    data class CharacterGridItemEpoxyModel(
        val characterId: Int,
        val imageUrl: String,
        val name:String,
        val onCharacterSelected: (Int)-> Unit
    ): ViewBindingKotlinModel<ActivityCharacterListItemBinding>(R.layout.activity_character_list_item){
        override fun ActivityCharacterListItemBinding.bind() {
            Picasso.get().load(imageUrl).into(characterIV)
            characterTV.text = name
            root.setOnClickListener {
                onCharacterSelected(characterId)
            }
        }

    }
}