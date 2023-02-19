package com.krisna.airwise.data.models

data class AirVisualResponse(
    val status: String,
    val data: AirVisualData
)

data class AirVisualData(
    val city: String,
    val state: String,
    val country: String,
    val current: AirVisualCurrent
)

data class AirVisualCurrent(
    val weather: AirVisualWeather,
    val pollution: AirVisualPollution
)

data class AirVisualWeather(
    val ts: String,
    val tp: Double,
    val pr: Int,
    val hu: Int,
    val ws: Double,
    val wd: Int,
    val ic: String
)

data class AirVisualPollution(
    val ts: String,
    val aqius: Int,
    val mainus: String,
    val aqicn: Int,
    val maincn: String
)