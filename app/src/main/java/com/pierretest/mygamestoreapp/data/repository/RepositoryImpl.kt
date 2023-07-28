package com.pierretest.mygamestoreapp.data.repository

import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleCategoryModel
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel
import com.pierretest.mygamestoreapp.data.remote.ApiCall

class RepositoryImpl (val apiCall: ApiCall): Repository {
    override suspend fun getSingleGameById(idGame: Int): SingleGameModel = apiCall.getSingleGameById(idGame)

    override suspend fun getAllGames(): List<SingleGameModel> {
        return apiCall.getAllGames()
    }

    override suspend fun getCategoryById(idCategory: String): List<SingleGameModel> {
        return apiCall.getCategoryById(idCategory)
    }

    override suspend fun getAllCategories(): List<String?> {
        val idCategory = 0
        val allGames = apiCall.getAllGames()
        val groupedGames = allGames.groupBy { it.genre?.trim() }
        return groupedGames.keys.toList()

    }

    override suspend fun getGamesByCategory(CategoryName: String): List<SingleGameModel> {
        TODO("Not yet implemented")
    }
}