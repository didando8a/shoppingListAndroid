package com.didando8a.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.didando8a.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names:List<String> = listOf("Consue", "Diego")
    ) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }

//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background,
//    ) {
//        Greeting(name = "Gabriel")
//    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember {
        mutableStateOf(false)
    }

    Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier.padding(vertical = 4.dp)) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {
            Text(modifier = modifier
                .fillMaxWidth(0.5f)
                .padding(vertical = 10.dp), text = name)
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }) {
                val messageString: String = if(expanded.value) "Show less" else "Show more"
                Text(modifier = modifier
                    .fillMaxWidth(0.5f)
                    , text = messageString)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}