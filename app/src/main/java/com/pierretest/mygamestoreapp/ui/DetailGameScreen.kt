package com.pierretest.mygamestoreapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel


@Composable
fun DetailGameScreen(singleGameModel: SingleGameModel) {
    // Fetch the data for the detail screen based on the itemId and display it here
    // For simplicity, let's just display the item ID for demonstration purposes
    Text(text = "Detail Screen for Item ${singleGameModel.title}")
}
