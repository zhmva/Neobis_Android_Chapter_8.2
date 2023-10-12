package com.srndpty.neobisandroidchapter8.api

class SessionManager {
    companion object {
        var USER_TOKEN = ""
    }

    fun saveAuthToken(token: String) {
        USER_TOKEN = token
    }

    fun fetchAuthToken(): String? {
        return USER_TOKEN
    }
}