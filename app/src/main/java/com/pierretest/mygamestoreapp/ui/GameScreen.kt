package com.pierretest.mygamestoreapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.pierretest.mygamestoreapp.Greeting
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel
import com.pierretest.mygamestoreapp.ui.theme.MyGameStoreAppTheme

@Composable
fun GameListScreen(  viewModel :GameViewModel = hiltViewModel()) {

    val gameList by viewModel.listAllGames.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(gameList){ game->
            GameItem(singleGameModel = game)
        }
    } 
}

@Composable
fun GameItem(singleGameModel: SingleGameModel) {
    Row(modifier = Modifier
        .fillMaxHeight()
        .padding(16.dp)
    ) {
        Image(
            modifier = Modifier.size(150.dp) ,
            painter = rememberAsyncImagePainter(singleGameModel.thumbnail),
            contentDescription = "thumbnail" )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            Text(text = singleGameModel.id.toString())
            Text(
                text = singleGameModel.title.toString(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                )
        }

    }
}

