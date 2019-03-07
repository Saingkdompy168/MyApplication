package com.example.user.myapplication.mvvm.navigator

import com.example.user.myapplication.mvvm.model.LoginResponseModel
import com.pathmazing.baserequest.mvvm.navigator.BaseNavigator

interface LoginNavigator : BaseNavigator {

    fun onLoginSuccess(login: LoginResponseModel)
}