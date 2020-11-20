package com.informatica404.coins3.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CryptoCoinsItem(
    @SerializedName("current_price")
    val currentPrice: Double,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
): Serializable