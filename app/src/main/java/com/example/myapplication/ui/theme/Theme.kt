package com.example.myapplication.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(

    primary = DarkPrimary,
    secondary = DarkSecondary,

    background = DarkBackground,
    surface = DarkSurface,

    onPrimary = Color.White,
    onSecondary = Color.White,

    onBackground = DarkOnBackground,
    onSurface = DarkOnSurface

)

private val LightColorScheme = lightColorScheme(

    primary = Primary,
    secondary = Secondary,

    background = Background,
    surface = Surface,

    onPrimary = OnPrimary,
    onSecondary = OnSecondary,

    onBackground = OnBackground,
    onSurface = OnSurface

)

@Composable
fun MyApplicationTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    dynamicColor: Boolean = false,

    content: @Composable () -> Unit

) {

    val colorScheme =
        when {

            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {

                val context = LocalContext.current

                if (darkTheme)
                    dynamicDarkColorScheme(context)
                else
                    dynamicLightColorScheme(context)

            }

            darkTheme -> DarkColorScheme

            else -> LightColorScheme

        }

    MaterialTheme(

        colorScheme = colorScheme,

        typography = Typography,

        content = content

    )

}