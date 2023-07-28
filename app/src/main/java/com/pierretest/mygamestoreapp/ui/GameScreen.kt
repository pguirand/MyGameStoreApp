package com.pierretest.mygamestoreapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun GameListScreen(navController: NavHostController,viewModel: GameViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getAllGames()
    }

    val gameList by viewModel.listAllGames.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(gameList) { game ->
            GameItem(singleGameModel = game){
                navController.navigate("DetailGameScreen/${game.id}")
            }
//            NewGameItem(singleGameModel = game)
        }
    }
}

@Composable
fun NewGameItem(singleGameModel: SingleGameModel) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
//        elevation =
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = singleGameModel.thumbnail,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(coil.compose.base.R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = singleGameModel.genre,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = singleGameModel.title.toString(),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = singleGameModel.title.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = singleGameModel.shortDescription.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameItem(singleGameModel: SingleGameModel, onItemClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(140.dp),
        shape = RoundedCornerShape(8.dp),
    )

    {

    Surface(
        onClick = onItemClick
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
//                .padding(4.dp)
                .background(Color(191, 234, 240, 255))
//                .background(Color.LightGray),



        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .fillMaxHeight()
                    .weight(0.4f),
                painter = rememberAsyncImagePainter(singleGameModel.thumbnail),
                contentDescription = "thumbnail"
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .weight(0.6f),

                ) {

                Text(
                    text = singleGameModel.title.toString().trim(),
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = singleGameModel.shortDescription.toString(),
                    fontSize = 14.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify

                )

            }
            }
        }

    }
    }


