package com.example.adit.loginjwt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.adit.loginjwt.models.Login
import com.example.adit.loginjwt.services.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://10.9.51.145:3000/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        loginBtn.setOnClickListener {
            login(retrofit)
        }

    }

    fun login(retrofit:Retrofit){
        val loginService = retrofit.create(LoginService::class.java)

        val login = Login(userName.text.toString(), password.text.toString())


        loginService.userLogin(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    user ->
                    Log.d("dodol", "id = ${user.user._id} token = ${user.token}")
                },{
                    error ->
                    Log.e("dodol", "$error")
                })
    }




}
