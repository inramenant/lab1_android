package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme


class MainActivity : ComponentActivity() {



    companion object{
        private const val TAG = "MainActivity"
    }

    private val logMessages = mutableListOf("Activity Lifecycle:")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        logMessages.add("onCreate")

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        logMessages.add("onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume")
        logMessages.add("onResume")


    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause")
        logMessages.add("onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop")
        logMessages.add("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
        logMessages.add("onRestart")
        setContent {
            Lab1Theme {
                State(logMessages)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        logMessages.add("onDestroy")
    }
}

@Composable
fun State(logMessages: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        items(logMessages) {message ->
            Text(text = message, modifier = Modifier.padding(bottom = 4.dp))
        }
    }
}

