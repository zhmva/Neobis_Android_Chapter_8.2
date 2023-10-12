package com.srndpty.neobisandroidchapter8.api

import com.srndpty.neobisandroidchapter8.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApi {
    @POST("api/auth/register")
    suspend fun register(@Body registrationForm: RegistrationForm): Response<Login>

    @POST("auth/login/")
    suspend fun login(@Body loginForm: Login): Response<LoginResponse>

    @PUT("auth/profile/")
    suspend fun profileSet(@Header("Authorization") token: String, @Body profileForm: ProfileForm)

    @PUT("auth/profile/")
    suspend fun getProfile(@Header("Authorization") token: String, @Body profile: Any): Response<ProfileForm>

    @PUT("auth/send-code/")
    suspend fun phoneNumber(@Header("Authorization") token: String, @Body phoneNumberForm: PhoneNumberForm)

}