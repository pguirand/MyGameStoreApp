package com.pierretest.mygamestoreapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierretest.mygamestoreapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel

class CategoryViewModel @Inject constructor(private val repository: Repository) :ViewModel(){

    private val _listAllCategories = MutableStateFlow<List<String>>(emptyList())

    init {
        getAllCategories()
    }
    val listAllCategories : StateFlow<List<String>> = _listAllCategories

    fun getAllCategories() {
        viewModelScope.launch {
            try {
                val catList = repository.getAllCategories()
                _listAllCategories.value = catList as List<String>
            } catch (e : Exception) {
                Log.e("CatList", e.message?: "Unexpected Error occurred")
            }
        }
    }
}