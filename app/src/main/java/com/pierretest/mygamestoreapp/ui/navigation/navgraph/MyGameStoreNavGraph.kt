package com.pierretest.mygamestoreapp.ui.navigation.navgraph


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pierretest.mygamestoreapp.ui.DetailGameScreen
import com.pierretest.mygamestoreapp.ui.GameListScreen
import com.pierretest.mygamestoreapp.ui.GameViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyGameStoreNavGraph(
    gameViewModel: GameViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.GAMES
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToGames() },
            navigateToCategories = { navigationActions.navigateToCategories() },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        val titleText = if (currentRoute == "DetailGameScreen/{gameId}") {
                            "Details"
                        } else {
                            currentRoute
                        }
                        Text(text = titleText)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }, content = {
                            Icon(
                                imageVector = Icons.Default.Menu, contentDescription = null
                            )
                        })
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                )
            }, modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = AllDestinations.GAMES,
                modifier = modifier.padding(it)
            ) {

                composable("DetailGameScreen/{gameId}") { backStackEntry ->
                    val gameId = backStackEntry.arguments?.getString("gameId")
                    val game =
                        gameViewModel.listAllGames.value.firstOrNull { it.id.toString() == gameId }
                    if (game != null) {
                        DetailGameScreen(game)
                    }
                }
                composable(AllDestinations.GAMES) {
                    GameListScreen(navController = navController)
                }

            }
        }
    }
}