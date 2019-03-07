package com.example.user.myapplication.mvvm.model

class LoginRequestModel{

    var password: String? = null
    var username: String? = null

    override fun toString(): String {
        return "LoginRequest{" +
                "password = '" + password + '\''.toString() +
                ",username = '" + username + '\''.toString() +
                "}"
    }
}