package com.jfalck.fizzbuzz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jfalck.fizzbuzz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }
    }
}