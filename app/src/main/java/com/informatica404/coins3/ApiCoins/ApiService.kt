package com.informatica404.coins3.ApiCoins

import com.informatica404.coins3.models.Coins
import com.informatica404.coins3.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    // Get coins and prices
    // https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin,tether,bitcoin-cash,ethereum,monero,Chainlink,litecoin,tezos,tron,rem,xrp,polkadot,tezos&order=market_cap_desc

    @GET("coins/markets")
    fun getCoins(
        @Query("ids") apikey: String = ApiRest.IDS,
        @Query("vs_currency") language: String = ApiRest.VS_CURRENCIES,
        @Query("order") order: String = ApiRest.ORDER
    ): Call<Coins>


    // Get News
    // https://min-api.cryptocompare.com/data/v2/news/

    @GET("news/")
    fun getNews(
        @Query("lang") language: String = ApiRest.lang
    ): Call<News>


    // https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=ethereum,bitcoin&order=market_cap_desc




}