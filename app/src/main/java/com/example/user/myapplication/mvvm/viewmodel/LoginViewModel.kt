package com.example.user.myapplication.mvvm.viewmodel

import com.example.user.myapplication.BuildConfig
import com.example.user.myapplication.mvvm.model.LoginRequestModel
import com.example.user.myapplication.mvvm.model.LoginResponseModel
import com.example.user.myapplication.mvvm.navigator.LoginNavigator
import com.example.user.myapplication.mvvm.rest.RestApi
import com.pathmazing.baserequest.mvvm.viewmodel.BaseViewModel
import com.pathmazing.baserequest.rest.RestClient
import com.pathmazing.baserequest.rest.disposable.HRDisposableSingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private var mNavigator: LoginNavigator) : BaseViewModel<LoginNavigator>(){

    private val api = RestClient.getApiService<RestApi>(BuildConfig.BASE_URL)

    fun onLogin(name:String,password:String){

        val loginRequest = LoginRequestModel()
        loginRequest.username = name
        loginRequest.password = password

        api.postUserLogin(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mNavigator.onShowProgress()
            }.doFinally {
                mNavigator.onDismissProgress()
            }.subscribeWith(object : HRDisposableSingleObserver<LoginResponseModel>(navigator) {
                override fun onSuccess(dealer: LoginResponseModel) {
                    mNavigator.onLoginSuccess(dealer)
                }

            }).addTo(compositeDisposable)
    }
}