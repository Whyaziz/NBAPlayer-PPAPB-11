package com.android.nbaplay.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data") val data: List<NbaPlayer>
)
