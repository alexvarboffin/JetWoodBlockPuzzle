package com.example.game

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.game.ui.AppNavigation
import com.example.game.ui.theme.VAITheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VAITheme {
                AppNavigation()
            }
        }
    }



    override fun onResume() {
        super.onResume()
    }
}
