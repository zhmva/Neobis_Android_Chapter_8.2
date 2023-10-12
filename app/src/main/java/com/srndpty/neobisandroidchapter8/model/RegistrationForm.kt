package com.srndpty.neobisandroidchapter8.model

data class RegistrationForm(
    val login: String,
    val email: String,
    val password: String,
    val confirm_password: String
)
