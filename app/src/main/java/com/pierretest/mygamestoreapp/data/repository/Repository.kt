package com.pierretest.mygamestoreapp.data.repository

import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleCategoryModel
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel

interface Repository {

    suspend fun getSingleGameById(idGame:Int) : SingleGameModel

    suspend fun getAllGames() : List<SingleGameModel>

    suspend fun getCategoryById(idCategory : String) : List<SingleGameModel>

    suspend fun getAllCategories(): List<String?>

    suspend fun getGamesByCategory(CategoryName:String) : List<SingleGameModel>
}