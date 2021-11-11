package com.example.koroutinesmvvm.presentation.controller

import com.airbnb.epoxy.EpoxyController
import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.common.LoadingEpoxyModel
import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import com.example.koroutinesmvvm.databinding.ModelCharacterDetailBottomBinding
import com.example.koroutinesmvvm.databinding.ModelCharacterDetailHeaderBinding
import com.example.koroutinesmvvm.databinding.ModelCharacterDetailImageBinding
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.presentation.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class CharacterDetailsEpoxyController: EpoxyController() {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if(field){
                requestModelBuild()
            }
        }
    var characterResponse: GetCharacterByIdMapper?= null
        set(value) {
            field = value
            if(field != null){
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        if(isLoading){
            LoadingEpoxyModel().id("loading").addTo(this)
            return
        }
        if(characterResponse == null){
            return
        }
        HeaderEpoxyModel(
            name = characterResponse?.name ?: "",
            status = characterResponse?.status ?: ""
        ).id("header").addTo(this)

        ImageEpoxyModel(
            imageUrl = characterResponse?.image ?: ""
        ).id("image").addTo(this)

        BottomEpoxyModel(
            title = "Origin",
            description = characterResponse?.origin?.name?: ""
        ).id("bottom_1").addTo(this)

        BottomEpoxyModel(
            title = "Species",
            description = characterResponse?.species ?: ""
        ).id("bottom_2").addTo(this)
    }

    data class HeaderEpoxyModel(
        val name:String,
        val status: String
    ):ViewBindingKotlinModel<ModelCharacterDetailHeaderBinding>(R.layout.model_character_detail_header){
        override fun ModelCharacterDetailHeaderBinding.bind() {
            tvName.text = name
            tvAlive.text = status
        }

    }

    data class ImageEpoxyModel(
        val imageUrl:String,
    ):ViewBindingKotlinModel<ModelCharacterDetailImageBinding>(R.layout.model_character_detail_image){
        override fun ModelCharacterDetailImageBinding.bind() {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }

    data class BottomEpoxyModel(
        val title:String,
        val description: String
    ):ViewBindingKotlinModel<ModelCharacterDetailBottomBinding>(R.layout.model_character_detail_bottom){
        override fun ModelCharacterDetailBottomBinding.bind() {
            tvOriginValue.text = title
            tvSpeciesValue.text = description

        }

    }
}