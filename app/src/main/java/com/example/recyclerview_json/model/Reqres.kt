package com.example.recyclerview_json.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)