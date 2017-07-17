package com.example.adit.loginjwt.services

import com.example.adit.loginjwt.models.Login
import com.example.adit.loginjwt.models.User
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by adit on 7/14/2017.
 */
interface LoginService {

    @POST("auth/login")
    fun userLogin(@Body login:Login): Observable<User>

}