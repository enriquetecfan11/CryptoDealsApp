package com.informatica404.coins3.ApiCoins

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRest {
    lateinit var service: ApiService

    // https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin,tether,bitcoin-cash,ethereum,monero,Chainlink,litecoin,tezos,tron,rem,xrp,polkadot,tezos&order=market_cap_desc

    val URL = "https://api.coingecko.com/api/v3/"
    val IDS = "bitcoin,tether,bitcoin-cash,ethereum,monero,Chainlink,litecoin,tezos,tron,rem,xrp,polkadot,tezos,maker,bittorrent,dogecoin,bitcoin-gold,balancer,nano,cardano,chainlink,eos,neo,dai,cardano"
    val VS_CURRENCIES ="eur"
    val ORDER = "market_cap_desc"


    val URL2 = "https://min-api.cryptocompare.com/data/v2/"
    val lang = "ES"


    fun initService(): ApiService {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }

    fun iniciarservicio(): ApiService {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(URL2)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }
}