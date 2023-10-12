package com.srndpty.neobisandroidchapter8.api

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(): Interceptor {

    val sessionManager = SessionManager()
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()

        val authenticatedRequest = originRequest.newBuilder()
            .header("Authorization", "Bearer ${SessionManager.USER_TOKEN}").build()

        return chain.proceed(authenticatedRequest)
    }
}