package com.example.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.game.ui.GameScreen
import com.example.game.ui.MenuScreen
import com.example.game.ui.SplashScreen
import com.example.game.ui.theme.VAITheme

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VAITheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen(onStartClick = { navController.navigate("menu") })
                    }
                    composable("menu") {
                        MenuScreen(onStartGame = { level -> navController.navigate("game/$level") })
                    }
                    composable(
                        "game/{level}",
                        arguments = listOf(navArgument("level") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val level = backStackEntry.arguments?.getInt("level") ?: 1
                        GameScreen(level = level, navController = navController)
                    }
                }
            }
        }
    }
}
