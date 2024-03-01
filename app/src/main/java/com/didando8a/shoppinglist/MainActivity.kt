package com.didando8a.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.didando8a.shoppinglist.ui.theme.ShoppingListTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable

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
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Welcome to Dani's lab")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Greetings()
}


@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names:List<String> = List(30) {"$it"}
) {
    LazyColumn(modifier = Modifier.padding(vertical = 10.dp)) {
        items (items =  names) { name ->
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
fun MyApp(modifier: Modifier = Modifier, ) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable {
        mutableStateOf(false)
    }

    var counter by rememberSaveable {
        mutableIntStateOf(0)
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
                onClick = {
                    expanded.value = !expanded.value
                    counter = counter.plus(1)
                }) {
                val messageString: String = if(expanded.value) "Show more ${counter}" else "Show less ${counter}"
                Text(modifier = modifier
                    .fillMaxWidth(0.5f)
                    , text = messageString)
            }
        }
    }
}

fun messageButtonPrinter(counter: MutableIntState): String
{
    return "The button has been clicked ${counter.intValue} times"
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}