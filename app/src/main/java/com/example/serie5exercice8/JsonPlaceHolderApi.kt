package com.example.serie5exercice8

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPosts():Call<List<Post>>
}