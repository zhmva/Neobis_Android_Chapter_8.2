package com.srndpty.neobisandroidchapter8.api

import com.srndpty.neobisandroidchapter8.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {

        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiAuth: AuthApi by lazy {
            retrofit.create(AuthApi::class.java)
        }
    }

}