package com.example.user.myapplication.mvvm.rest

import com.example.user.myapplication.mvvm.model.LoginRequestModel
import com.example.user.myapplication.mvvm.model.LoginResponseModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi{

    @POST("auth/login")
    fun postUserLogin(
        @Body loginRequest: LoginRequestModel
    ): Single<LoginResponseModel>



    @POST("auth/login")
    fun postUserLogin1(
        @Body loginRequest: LoginRequestModel
    )

}