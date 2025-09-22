package com.example.game.ui

import android.content.Context
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

//private fun openUrl(context: Context, url: String) {
//    val builder = CustomTabsIntent.Builder()
//    val customTabsIntent = builder.build()
//    customTabsIntent.launchUrl(context, url.toUri())
//}


fun openUrl(context: Context, url: CharArray) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(context, String(url).toUri())
}