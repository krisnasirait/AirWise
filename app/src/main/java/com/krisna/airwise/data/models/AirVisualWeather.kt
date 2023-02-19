package com.krisna.airwise.data.models

data class AirVisualWeather(
    val ts: String,
    val tp: Double,
    val pr: Int,
    val hu: Int,
    val ws: Double,
    val wd: Int,
    val ic: String
)