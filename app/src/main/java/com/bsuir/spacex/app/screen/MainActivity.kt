package com.bsuir.spacex.app.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bsuir.spacex.app.utils.observeEvent
import com.bsuir.spacex.Singletons
import com.bsuir.spacex.app.screen.graphs.RootNavigationGraph
import com.bsuir.spacex.app.views.AppViewModel
import com.bsuir.spacex.ui.theme.SpaceXTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AppViewModel>()
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        Singletons.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
        observeShowAuthMessageEvent()
    }

    private fun observeShowAuthMessageEvent() = viewModel.message.observeEvent(lifecycleOwner = this) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }


}

