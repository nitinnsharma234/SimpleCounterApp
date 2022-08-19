package com.example.simplecounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplecounterapp.ui.theme.SimpleCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                    ) {
                    val counterViewModel: CounterViewModel by viewModels()
                    CounterApp(cv=counterViewModel)
                    }
            }
        }
    }
}

@Composable
fun CounterApp(cv:CounterViewModel= viewModel())
{
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {


        Text(cv.tick.value.toString(), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { cv.add() }) {
            Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null)
        }
        Button(onClick = { cv.substract() }) {
            Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = null)
        }
    }


}
