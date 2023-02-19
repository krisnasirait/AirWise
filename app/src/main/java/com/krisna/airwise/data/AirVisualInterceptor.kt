package com.krisna.airwise.data

import okhttp3.Interceptor
import okhttp3.Response

class AirVisualInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("key", apiKey)
            .build()
        return chain.proceed(request)
    }
}