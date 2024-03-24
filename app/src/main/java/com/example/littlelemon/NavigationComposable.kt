package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavigation(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LemonStorage", Context.MODE_PRIVATE)
    var isUserLoggedIn = sharedPreferences.getBoolean("userRegistered", false)
    NavHost(
        navController = navController,
        startDestination = if (isUserLoggedIn) Home.route else Onboarding.route
    ) {
        composable(route = Onboarding.route) {
            Onboarding(navController = navController)
        }
        composable(route = Home.route) {
            Home(navController = navController)
        }
        composable(route = Profile.route) {
            Profile(navController = navController)
        }
    }

}