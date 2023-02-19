package com.krisna.airwise.data.models

data class AirVisualData(
    val city: String,
    val state: String,
    val country: String,
    val current: AirVisualCurrent
)