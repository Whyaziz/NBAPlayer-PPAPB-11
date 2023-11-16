package com.android.nbaplay.network

import com.android.nbaplay.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("players")
    fun getPlayerData(): Call<ApiResponse>
}