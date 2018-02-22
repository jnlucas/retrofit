package com.example.logonrm.pokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logonrm.pokemon.api.PokemonAPI
import com.example.logonrm.pokemon.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesquisar.setOnClickListener {

            pesquisarPokemon()
        }
    }

    fun pesquisarPokemon() {

        nome.text.toString()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create<PokemonAPI>(PokemonAPI::class.java!!)

        api.buscarPokemon(nome.text.toString().toInt())
            .enqueue(object : Callback<Pokemon> {
                override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {

                }

                override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {

                }
            })


    }
}
