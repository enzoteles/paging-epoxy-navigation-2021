package com.example.koroutinesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import com.example.koroutinesmvvm.databinding.ActivityMainBinding
import com.example.koroutinesmvvm.presentation.viewmodel.ShareViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    //instanciando o view model
    val viewModel: ShareViewModel by lazy {
        ViewModelProvider(this).get(ShareViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //usando o método do viewmodel
        viewModel.refreshCharacter(10)
        viewModel.characterByIdLiveData.observe(this){ response->
            if(response == null){
                Toast.makeText(this@MainActivity, "Unsucceful network call", Toast.LENGTH_SHORT).show()
            }

            binding.tvName.text = response?.name
            binding.tvAlive.text = response?.status
            binding.tvOriginValue.text = response?.species
            binding.tvSpeciesValue.text = response?.origin?.name
            Picasso.get().load(response?.image).into(binding.imageView);
        }

    }
}