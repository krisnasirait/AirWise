package com.krisna.airwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.krisna.airwise.data.AirVisualRepository
import com.krisna.airwise.data.viewmodel.AirVisualViewModel
import com.krisna.airwise.databinding.ActivityMainBinding
import com.krisna.airwise.di.ViewModelFactory
import com.krisna.airwise.di.ViewModelFactory.Companion.service

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AirVisualViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // Install splash screen
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = AirVisualRepository(service)
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AirVisualViewModel::class.java)

        viewModel.data.observe(this) { airVisualData ->
            binding.tvCity.text = airVisualData.city
            binding.tvDate.text = airVisualData.current.weather.ts
            binding.tvTemp.text = airVisualData.current.weather.tp.toString()
        }

        viewModel.loadData()
    }
}