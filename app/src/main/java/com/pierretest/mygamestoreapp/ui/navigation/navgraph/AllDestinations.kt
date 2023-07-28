package com.pierretest.mygamestoreapp.ui.navigation.navgraph


import androidx.navigation.NavHostController
import com.pierretest.mygamestoreapp.ui.navigation.navgraph.AllDestinations.CATEGORIES
import com.pierretest.mygamestoreapp.ui.navigation.navgraph.AllDestinations.GAMES

object AllDestinations {
    const val GAMES = "Games"
    const val CATEGORIES = "Categories"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToGames() {
        navController.navigate(GAMES) {
            popUpTo(GAMES)
        }
    }

    fun navigateToCategories(){
        navController.navigate(CATEGORIES)
    }
}