package com.pierretest.mygamestoreapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleCategoryModel

@Composable
fun CategoryListScreen(viewModel: CategoryViewModel = hiltViewModel()) {



    val catList by viewModel.listAllCategories.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        items(catList) { cat ->
            CategoryItem(categoryModel = cat)
        }
    }

}


@Composable
fun CategoryItem(categoryModel: String) {

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
//        elevation =
    ) {


        Surface(
            Modifier
                .padding(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)
                    .background(Color(200, 200, 100)),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
            ) {
                Text(

                    text = categoryModel,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(8.dp)
                )
                Divider(
                    modifier = Modifier
                        .padding(8.dp),
//                        .height(6.dp),
                    color = Color(97, 100, 100, 255)

                )

            }

        }
    }


}



