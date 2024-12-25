package com.example.projectapi

import retrofit2.Call
import retrofit2.http.GET

interface api {
    @GET("products")
    fun getproductdata() : Call<Mydata>

}