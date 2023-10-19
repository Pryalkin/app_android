package com.bsuir.spacex.app.screen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bsuir.spacex.Singletons
import com.bsuir.spacex.app.screen.item.ShipItem

@Composable
fun HomeContext(
    navController: NavController
) {
    val viewModel = Singletons.appViewModel
    val ships = viewModel.ships.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.getAllShip()
    }
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = ships.value) { ship ->
            ShipItem(ship = ship, navController = navController)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeContextPreview() {
    HomeContext(navController = rememberNavController())
}