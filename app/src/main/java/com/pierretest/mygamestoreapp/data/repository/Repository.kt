package com.pierretest.mygamestoreapp.data.repository

import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel

interface Repository {

    suspend fun getSingleGameById(idGame:Int) : SingleGameModel

    suspend fun getAllGames() : List<SingleGameModel>

    suspend fun getCategoryById(idCategory : String) : List<SingleGameModel>
}