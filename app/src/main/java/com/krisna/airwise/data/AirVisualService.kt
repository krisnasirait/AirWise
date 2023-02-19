package com.krisna.airwise.data

import com.krisna.airwise.data.models.AirVisualResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface AirVisualService {
    @GET("nearest_city")
    suspend fun getNearestCity(@Header("apikey") apiKey: String): AirVisualResponse
}