package com.informatica404.coins3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.informatica404.coins3.models.CryptoCoinsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_item.view.*

class MainAdapter(private val mDataSet: List<CryptoCoinsItem>, val function: (CryptoCoinsItem) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        return MainViewHolder(v)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet.get(position)
        holder.bindItems(data)
        holder.itemView.setOnClickListener {
            function(data!!)
        }
    }
    override fun getItemCount(): Int {
        return mDataSet.size

    }
    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: CryptoCoinsItem) {
            val precio = "Valor: " + data.currentPrice + " €"

            v.cryptoname.text = data.name
            v.cryptoprice.text = precio
            Picasso.get().load(data.image).resize(500, 500).into(v.cryptologo)
        }
    }
}
