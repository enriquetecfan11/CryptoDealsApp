package com.informatica404.coins3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.informatica404.coins3.models.CryptoCoinsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_coin.*

class singlecoin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_coin)
    /*
        val bundle = intent.extras
        bundle?.let {
            val heroe = bundle?.get("heroe") as CryptoCoinsItem
            title = heroe.name
            Picasso.get().load(heroe.image).into(coinlogo)
            coinname.text = heroe.id
            coinprice.text = heroe.currentPrice.toString()
        }
    */
    }
}