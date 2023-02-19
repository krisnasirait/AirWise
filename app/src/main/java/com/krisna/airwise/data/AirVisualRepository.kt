package com.krisna.airwise.data

import com.krisna.airwise.BuildConfig
import com.krisna.airwise.data.models.AirVisualData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AirVisualRepository(private val service: AirVisualService) {
    suspend fun getNearestCity(): AirVisualData {
        val apiKey = BuildConfig.IQair_KEY
        val response = service.getNearestCity(apiKey)
        return response.data
    }
}

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.airvisual.com/v2/")
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

val service = retrofit.create(AirVisualService::class.java)

