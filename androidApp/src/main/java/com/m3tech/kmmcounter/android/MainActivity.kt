package com.m3tech.kmmcounter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m3tech.kmmcounter.Counter
import com.m3tech.kmmcounter.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counter = Counter() // shared KMM class
        setContent {
            MyApplicationTheme(
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // ensures light background
                ) {
                    CounterScreen(counter)
                }
            }
        }
    }
}

/**
 * ✅ This is the actual UI Composable that uses the shared Counter logic.
 */
@Composable
fun CounterScreen(counter: Counter) {
    var value by remember { mutableStateOf(counter.getCount()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: $value")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            value = counter.increment()
        }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            counter.reset()
            value = counter.getCount()
        }) {
            Text(text = "Reset")
        }
    }
}

/**
 * Preview function to see the UI directly in Android Studio.
 * For preview, we can use a local Counter (not the one from Activity).
 */
@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CounterScreen(counter = Counter())
}