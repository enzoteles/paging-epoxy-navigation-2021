package com.example.koroutinesmvvm.common

import com.example.koroutinesmvvm.domain.datasource.ShareDataSource
import com.example.koroutinesmvvm.domain.datasource.ApiClient
import com.example.koroutinesmvvm.common.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Data Source (Fonte de Dados na arquitetura MVVM)
//futuramente ele vai ser injetado pelo Koin ou High Dagger
object NetworkLayer {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val SHARE_DATA_SOURCE: ShareDataSource by lazy {
        retrofit.create(ShareDataSource::class.java)
    }
    val apiClient = ApiClient(SHARE_DATA_SOURCE)
}