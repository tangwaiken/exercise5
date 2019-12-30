package com.example.exercise5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.exercise_5.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Module-level variable
    lateinit var countViewModel: CountViewModel
    //Create an instance of the Shared Preferences
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        //Initialise the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Initialise the Shared Preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        textViewLike.text = countViewModel.counterLike.toString()
        textViewDislike.text = countViewModel.counterDislike.toString()

        imageViewLike.setOnClickListener {
            countViewModel.counterLike++
            textViewLike.text = countViewModel.counterLike.toString()
        }

        imageViewDislike.setOnClickListener {
            countViewModel.counterDislike++
            textViewDislike.text = countViewModel.counterDislike.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity" , "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity" , "onResume")
        countViewModel.counterLike =
            sharedPreferences.getInt(getString(R.string.counterLike), 0)
        countViewModel.counterDislike =
            sharedPreferences.getInt(getString(R.string.counterDislike), 0)
        textViewLike.text = countViewModel.counterLike.toString()
        textViewDislike.text = countViewModel.counterDislike.toString()
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity" , "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.counterLike), countViewModel.counterLike)
            putInt(getString(R.string.counterDislike), countViewModel.counterDislike)
            commit()
        }
        super.onPause()

        //79 03 91 8-10
        //24 46 98 10-12
    }

    override fun onStop() {
        Log.d("MainActivity" , "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity" , "onDestroy")
        super.onDestroy()
    }
}
