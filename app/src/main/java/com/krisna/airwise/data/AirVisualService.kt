package com.krisna.airwise.data

import com.krisna.airwise.data.models.AirVisualResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AirVisualService {
    @GET("nearest_city")
    suspend fun getNearestCity(@Query("key") apiKey: String): AirVisualResponse
}