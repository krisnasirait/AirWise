package com.krisna.airwise.data

import com.krisna.airwise.BuildConfig
import com.krisna.airwise.data.models.AirVisualData

class AirVisualRepository(private val service: AirVisualService) {
    suspend fun getNearestCity(): AirVisualData {
        val apiKey = BuildConfig.IQair_KEY
        val response = service.getNearestCity(apiKey)
        return response.data
    }
}

