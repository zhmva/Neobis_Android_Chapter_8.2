package com.srndpty.neobisandroidchapter8.repo

import com.srndpty.neobisandroidchapter8.api.RetrofitInstance
import com.srndpty.neobisandroidchapter8.api.SessionManager
import com.srndpty.neobisandroidchapter8.model.Login
import com.srndpty.neobisandroidchapter8.model.ProfileForm
import com.srndpty.neobisandroidchapter8.model.RegistrationForm

class AuthRepository {

    private val authApi = RetrofitInstance.apiAuth

    suspend fun register(registrationForm: RegistrationForm) = authApi.register(registrationForm)

    suspend fun login(loginForm: Login) = authApi.login(loginForm)

    suspend fun getProfile() = authApi.getProfile(SessionManager.USER_TOKEN, ProfileForm("", "", "", "", ""))

}