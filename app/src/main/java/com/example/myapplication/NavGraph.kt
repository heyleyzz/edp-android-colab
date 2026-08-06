package com.example.myapplication

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        // Home Screen Destination
        composable<Home> {
            HomeScreen(onShowGreeting = { typedName ->
                navController.navigate(Greeting(userName = typedName))
            })
        }

        // Greeting Screen Destination with Pop-Up Animations
        composable<Greeting>(
            enterTransition = {
                scaleIn(initialScale = 0.7f, animationSpec = tween(400)) + fadeIn(animationSpec = tween(400))
            },
            exitTransition = {
                scaleOut(targetScale = 0.7f, animationSpec = tween(400)) + fadeOut(animationSpec = tween(400))
            },
            popExitTransition = {
                scaleOut(targetScale = 0.7f, animationSpec = tween(400)) + fadeOut(animationSpec = tween(400))
            }
        ) { backStackEntry ->
            val greeting: Greeting = backStackEntry.toRoute()
            GreetingScreen(
                userName = greeting.userName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}