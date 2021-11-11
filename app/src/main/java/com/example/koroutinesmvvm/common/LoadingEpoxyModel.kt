package com.example.koroutinesmvvm.common

import com.example.koroutinesmvvm.R
import com.example.koroutinesmvvm.databinding.ModelLoadingBinding
import com.example.koroutinesmvvm.presentation.epoxy.ViewBindingKotlinModel

class LoadingEpoxyModel: ViewBindingKotlinModel<ModelLoadingBinding>(R.layout.model_loading) {
    override fun ModelLoadingBinding.bind() {
        //nothing to do
    }

}