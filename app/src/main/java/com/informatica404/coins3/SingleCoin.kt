package com.informatica404.coins3

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.informatica404.coins3.models.CryptoCoinsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_item.*
import kotlinx.android.synthetic.main.crypto_item.view.*
import kotlinx.android.synthetic.main.fragment_single_coin.*


class SingleCoin : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.informatica404.coins3.R.layout.fragment_single_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val moneda = arguments?.getSerializable("coin") as CryptoCoinsItem


        Picasso.get().load(moneda.image).resize(500, 500).into(img)
        tvname.text = moneda.name
        tvprice.text = moneda.currentPrice.toString() + "$"


    }
}