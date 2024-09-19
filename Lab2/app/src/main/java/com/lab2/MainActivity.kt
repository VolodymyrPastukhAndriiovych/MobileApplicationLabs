package com.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lab2.ui.theme.Lab2Theme


/**
 * Lab2 ToDo Додаток
 * - зробіть список з туду айтемами (наповніть їх красивіше, більше інфи якоїсь, 2-3 текстовки, айдішка, можна іконку додати до кожного)
 * - налаштуйте додавання айтемів, спробуйте налаштувати видалення айтемів зі списку
 * - максимально пограйтесь з UI
 *
 * Що варто вивчити та з чим попрактикуватись
 * Kotlin:
 * - functions
 * - data class
 * - List (extensions listOf, mutableListOf)
 *
 * Android Compose:
 * - composable function
 * - states, remember{}, mutableStateOf()
 * - Modifier (.fillMaxSize(), .fillMaxWidth())
 * - containers (Column, Row, LazyColumn, LazyRow, Button)
 * - single views (Text, TextField)
 */


/**
 * MainActivity
 * - entrypoint of application (extends ComponentActivity() which allows Compose)
 * - starts the compose UI by setContent{}
*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Lab2Theme the container with app theme (shares the attributes like colors, typography, etc. for all nested composable views)
            Lab2Theme {
                // ... starting of custom composable view MainActivityScreen()
                MainActivityScreen()
            }
        }
    }
}

/** MainActivityScreen()
 * - composable function for custom view
 */
@Composable
fun MainActivityScreen() {
    // itemList - the state with list for storing and updating data on screen dynamically
    // TODO: ! Learn more about State in Compose and remember{} !
    val itemList = remember { mutableStateListOf<Item>() }

    //  Column() [vertical] - Composable function for displaying any type items (other Composable views) in column
    // TODO: ! Practice with Column() and Row() !
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        //  LazyColumn() - same as Column(), but for unknown amount of items, includes scroll
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .weight(7.0f)
                .background(Color.Green),
        ) {
            items(itemList) { item ->
                //  Row() [horizontal] - same as Column(), but horizontal
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue)
                        .padding(top = 12.dp)
                ) {
                    //  Text() - simple view for displaying text
                    Text(text = "Id ${item.id}")
                    Text(text = item.name)
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .weight(3.0f)
                .background(Color.Yellow),
        ) {
            //  states for storing strings values of textFields
            // TODO: Learn Mode about State, remember {}, mutableStateOf()
            val textFieldId = remember { mutableStateOf("") }
            val textFieldName = remember { mutableStateOf("") }

            //  TextField() -  view for displaying and inputting text
            TextField(
                value = textFieldId.value, //displays value from state
                onValueChange = { newId -> textFieldId.value = newId }, // change value in state
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = textFieldName.value,
                onValueChange = { newName -> textFieldName.value = newName },
                modifier = Modifier.fillMaxWidth()
            )
            //  Button() -  default button container
            Button(
                onClick = {  //  button click action
                    itemList.add(
                        Item(
                            id = textFieldId.value,
                            name = textFieldName.value,
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                //  button content -  here just includes one Text()
                Text(text = "Submit")
            }
        }
    }
}

/**
 * Item
 * - data class to store info (more than one)
 * - can be extended by other info
 */
data class Item(val id: String, val name: String)


/**
 * MainActivityPreview
 * - just preview for developing
 */
@Preview
@Composable
fun MainActivityPreview() {
    Lab2Theme {
        MainActivityScreen()
    }
}