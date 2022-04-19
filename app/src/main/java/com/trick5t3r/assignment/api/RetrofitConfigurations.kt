package com.trick5t3r.assignment.api

import com.trick5t3r.assignment..model.Photo
import com.trick5t3r.assignment..model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id: String): Call<User>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com"
        fun create(): UserAPIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()
            return retrofit.create(UserAPIService::class.java)
        }
    }
}