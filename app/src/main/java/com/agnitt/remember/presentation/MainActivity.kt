package com.agnitt.remember.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.agnitt.remember.presentation.screens.MainScreen
import com.agnitt.remember.presentation.screens.MainScreenContent
import com.agnitt.remember.presentation.screens.TestScreen
import com.agnitt.remember.presentation.theme.RememberTheme
import com.agnitt.remember.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent { MainScreenContent(viewModel) }
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