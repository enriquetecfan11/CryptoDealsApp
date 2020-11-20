package com.informatica404.coins3.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CryptoCoins(
    @SerializedName("data")
    val `data`: List<CryptoCoinsItem>
): Serializable