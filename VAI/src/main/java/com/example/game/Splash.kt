package com.example.game

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.game.ui.screens.splash.SplashScreen
import com.example.game.ui.theme.VAITheme

class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VAITheme {
                SplashScreen(onNavigateToHome = {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                })
            }
        }
    }
}


