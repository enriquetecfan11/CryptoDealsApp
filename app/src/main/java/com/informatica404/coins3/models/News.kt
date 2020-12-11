package com.informatica404.coins3.models

data class News(
    val Data: List<Data>,
    val HasWarning: Boolean,
    val Message: String,
    val Promoted: List<Any>,
    val RateLimit: RateLimit,
    val Type: Int
)