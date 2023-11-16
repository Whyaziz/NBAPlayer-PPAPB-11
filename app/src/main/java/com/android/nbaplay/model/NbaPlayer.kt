package com.android.nbaplay.model

import com.google.gson.annotations.SerializedName

data class NbaPlayer(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("position") val position: String,
    @SerializedName("team") val team: Team?,
)

data class Team(
    @SerializedName("id") val id: Int,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("city") val city: String,
    @SerializedName("conference") val conference: String,
    @SerializedName("division") val division: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("name") val name: String
)