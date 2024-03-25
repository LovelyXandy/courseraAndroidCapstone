package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavigation(context: Context, navController: NavHostController, databaseMenuItems: List<MenuItem>) {
    val sharedPreferences = context.getSharedPreferences(
        ContextCompat.getString(
            context,
            R.string.sharedPreferenceKey
        ), Context.MODE_PRIVATE)
    var isUserLoggedIn = sharedPreferences.getBoolean("userRegistered", false)
    NavHost(
        navController = navController,
        startDestination = if (isUserLoggedIn) Home.route else Onboarding.route
    ) {
        composable(route = Onboarding.route) {
            Onboarding(context= context, navController = navController)
        }
        composable(route = Home.route) {
            Home(context= context, navController = navController, databaseMenuItems = databaseMenuItems)
        }
        composable(route = Profile.route) {
            Profile(context= context, navController = navController)
        }
    }

}