package com.example.userinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.userinfo.components.Homepage
import com.example.userinfo.components.LangPages

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            Homepage(navController)
        }
        composable(
            route = Screen.LangPage.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Subject"
                }
            )) { entry ->
            entry.arguments?.getString("name")?.let { LangPages(navController, name = it) }
        }
    }
}