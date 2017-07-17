package com.example.adit.loginjwt.models


/**
 * Created by adit on 7/14/2017.
 */
data class User (val user: UserDetail, val token:String)

data class UserDetail(val _id: String)