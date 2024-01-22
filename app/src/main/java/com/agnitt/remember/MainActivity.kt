package com.agnitt.remember

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.agnitt.remember.ui.theme.RememberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            RememberTheme(isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier.weight(7f),
                            contentAlignment = Alignment.Center
                        ) {
                            Greeting("I hate it cuz feel self so stupid and embarrassed")
                        }
                        Switch(
                            modifier = Modifier
                                .align(Alignment.End)
                                .weight(1f),
                            checked = isDarkTheme,
                            onCheckedChange = { isDarkTheme = it }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(msg: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi, dorks! $msg T_T",
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
