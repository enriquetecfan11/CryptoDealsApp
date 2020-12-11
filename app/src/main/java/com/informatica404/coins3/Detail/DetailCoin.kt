package com.informatica404.coins3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_coin.*
import kotlinx.android.synthetic.main.crypto_item.*
import kotlinx.android.synthetic.main.crypto_item.view.*

class DetailCoin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_coin)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        Picasso.get().load(DataHolder.coin?.image).into(img)

        tvname.text = DataHolder.coin?.name.toString()

        tvprice.text = "Price: " +DataHolder.coin?.current_price.toString() + " €"

        tvhigh.text = "Price High: " +  DataHolder.coin?.high_24h.toString() + " €"

        tvlow.text = "Price Low: " +  DataHolder.coin?.low_24h.toString() + " €"

        tvmark.text = "Total Market Price: " + DataHolder.coin?.market_cap.toString() + " €"

        tvolume.text = "Total Volume: " + DataHolder.coin?.total_volume.toString() + " €"
    }
}