package com.pierretest.mygamestoreapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel
import com.pierretest.mygamestoreapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "GameViewModel"

@HiltViewModel
class GameViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _listAllGames = MutableStateFlow<List<SingleGameModel>>(emptyList())

    init {
        getAllGames()
    }
    val listAllGames: StateFlow<List<SingleGameModel>> = _listAllGames

    fun getAllGames() {
        viewModelScope.launch {
            try {
                val gamesList = repository.getAllGames()
                _listAllGames.value = gamesList
            } catch (e: Exception) {
                Log.e(TAG, e.message ?: "unexpected error occurred")
            }
        }
    }


}