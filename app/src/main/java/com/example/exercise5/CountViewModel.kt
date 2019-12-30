
package com.example.exercise_5

import android.util.Log
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    var counterLike: Int = 0
    var counterDislike: Int = 0

    init {
        Log.d("CounterViewModel", "ViewModel created")
    }

    override fun onCleared() {
        Log.d("CounterViewModel", "ViewModel destroyed")
        super.onCleared()
    }
}