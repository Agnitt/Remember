package com.agnitt.remember.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.agnitt.remember.presentation.theme.RememberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isDarkTheme = mutableStateOf(false)

        setContent { MainScreen(isDarkTheme) }
    }


}

@Composable
fun Greeting(msg: String, modifier: Modifier = Modifier) {
    Text(
        text = "$msg T_T",
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RememberTheme {
        Greeting("Android")
    }
}