package com.krisna.airwise.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krisna.airwise.data.AirVisualRepository
import com.krisna.airwise.data.AirVisualService
import com.krisna.airwise.data.viewmodel.AirVisualViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ViewModelFactory(private val repository: AirVisualRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            AirVisualViewModel::class.java -> AirVisualViewModel(repository) as T
            else -> throw UnsupportedOperationException()
        }
    }
    
    companion object {
        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.airvisual.com/v2/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service: AirVisualService = retrofit.create(AirVisualService::class.java)
    }
}