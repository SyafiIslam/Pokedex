package com.syafi.pokedex.repository

import com.syafi.pokedex.data.Resource
import com.syafi.pokedex.data.remote.PokeAPI
import com.syafi.pokedex.data.remote.response.Pokemon
import com.syafi.pokedex.data.remote.response.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("e")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonDetail(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(name)
        } catch (e: Exception) {
            return Resource.Error("e")
        }
        return Resource.Success(response)
    }
}