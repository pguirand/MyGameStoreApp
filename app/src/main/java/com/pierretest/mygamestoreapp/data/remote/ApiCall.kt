package com.pierretest.mygamestoreapp.data.remote

import com.pierretest.mygamestoreapp.common.ApiDetails
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET(ApiDetails.SINGLE_GAME_END_POINT)
    suspend fun getSingleGameById(@Query("id") id:Int) : SingleGameModel

    @GET(ApiDetails.ALL_GAMES_END_POINT)
    suspend fun getAllGames() : List<SingleGameModel>

    @GET(ApiDetails.CATEGORY_END_POINT)
    suspend fun getCategoryById(@Query("category") category:String) : List<SingleGameModel>

}