package com.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lab1.ui.theme.Lab1Theme

/**
 * MainActivity - the class which starts the UI rendering. Entrypoint of application.
 * - extends on ComponentActivity superclass which allows to run Compose views
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent{ ...compose functions() } compose container in Activity for compose UI
        setContent {
            // Lab1Theme - automatically generated theme of app with corresponding name
            // - compose root container which shares the theme attributes (colors, typo, etc) with all nested compose views
            Lab1Theme {
                // Surface - simple compose wrapper which can be modified (color, elevation, border, etc)
                Surface(
                    // Modifier - the object which is included in each compose function as parameter
                    // - is used for manual modifying the view (observe more by typing `Modifier.` and see the available functions)
                    // - Modifier.fillMaxSize() - spreads the view on all available space (size of screen in this example)
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Invocation of custom compose function
                    Greeting("Android")
                }
            }
        }
    }
}

/**
    Greeting - custom compose function
    [name] - custom parameter
    [modifier] - mandatory parameter in all compose functions (custom as well) for UI modifications
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}


/**
    GreetingPreview - the compose function where is invoked custom compose function Greeting and marked with annotation @Preview
    - is used to observe the view without running the app
 */
@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    Lab1Theme {
        Greeting("Volodymyr Andriiovych")
    }
}
