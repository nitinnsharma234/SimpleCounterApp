package com.example.simplecounterapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel:ViewModel(){
    val tick= mutableStateOf(1)

    fun add()
    {
        tick.value+=1
    }
    fun substract()
    {
        if(tick.value>0) {
            tick.value -= 1
        }
    }
}