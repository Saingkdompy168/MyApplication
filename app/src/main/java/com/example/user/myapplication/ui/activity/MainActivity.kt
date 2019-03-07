package com.example.user.myapplication.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.user.myapplication.R
import com.example.user.myapplication.mvvm.model.LoginResponseModel
import com.example.user.myapplication.mvvm.navigator.LoginNavigator
import com.example.user.myapplication.mvvm.viewmodel.LoginViewModel
import com.example.user.mylibrary1.Util
import com.pathmazing.baserequest.mvvm.model.ErrorModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), LoginNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_login.setOnClickListener {
            val loginViewModel = LoginViewModel(this)
            loginViewModel.onLogin(edit_text_name.text.toString().trim(), edit_text_password.text.toString().trim())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.changecolor, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.about -> {
                Util.darkenStatusBar(this, R.color.colorPrimaryDark)
                Util.setBackground(button_login, R.color.colorPrimaryDark)
            }
            R.id.feeds -> {
//                whiteLabelColor(this, R.color.colorCyan)
                Util.darkenStatusBar(this,R.color.colorCyan)
                Util.setBackground(button_login,R.color.colorCyan)
            }
            R.id.friends -> {
//                whiteLabelColor(this, R.color.colorYellow)
                Util.darkenStatusBar(this,R.color.colorYellow)
                Util.setBackground(button_login,R.color.colorYellow)
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun whiteLabelColor(context: Context, colorId: Int) {
//        val mActionBar: ActionBar? = supportActionBar
//        window.statusBarColor = ContextCompat.getColor(context, colorId)
//        mActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context, colorId)))
//        button_login.setBackgroundResource(colorId)
//    }

    override fun onLoginSuccess(login: LoginResponseModel) {
        Toast.makeText(this, login.lastName + "" + login.firstName, Toast.LENGTH_SHORT).show()
    }

    override fun onConnectionError() {
        Toast.makeText(this, "Connection error", Toast.LENGTH_SHORT).show()
    }

    override fun onDismissProgress() {
//        Toast.makeText(this,"hide progress",Toast.LENGTH_SHORT).show()
    }

    override fun onError(errorModel: ErrorModel) {
        Toast.makeText(this, errorModel.message, Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onShowMessage(message: String) {
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onShowProgress() {
//        Toast.makeText(this,"Show progress",Toast.LENGTH_SHORT).show()
    }
}
