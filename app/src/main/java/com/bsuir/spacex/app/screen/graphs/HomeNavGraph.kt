package com.bsuir.spacex.app.screen.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bsuir.spacex.Singletons
import com.bsuir.spacex.app.screen.screens.*

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Home.route,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable (route = BottomBarScreen.Home.route) {
            val viewModel = Singletons.appViewModel
            val company = viewModel.company.observeAsState()
            LaunchedEffect(Unit) {
                viewModel.getCompany()
            }
            company.value?.let { it1 -> SpaceXContext(company = it1) }
        }
        composable(route = BottomBarScreen.Profile.route) {
            HomeContext(navController = navController)
        }
        composable(
            route = Screen.DetailId.route,
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                })
        ){
            val viewModel = Singletons.appViewModel
            val launch = viewModel.launch.observeAsState()
            val launchpad = viewModel.launchpad.observeAsState()
            LaunchedEffect(Unit) {
                viewModel.getLaunch(it.arguments?.getString("id").toString())
            }

            launch.value?.let { it1 -> launchpad.value?.let { it2 -> DetailScreen(it1, it2) } }
        }
    }
}

