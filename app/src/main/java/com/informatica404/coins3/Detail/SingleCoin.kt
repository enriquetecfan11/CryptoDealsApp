package com.informatica404.coins3


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.informatica404.coins3.models.CoinsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_item.view.*


class SingleCoin(val data: ArrayList<CoinsItem>, val OnClick: (CoinsItem) -> Unit) :
    RecyclerView.Adapter<SingleCoin.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")

        fun bind(item: CoinsItem) {

            itemView.cryptoname.text = item.name
            itemView.cryptoprice.text = item.current_price.toString() + " €"
            Picasso.get().load(item.image).into(itemView.cryptologo)

            itemView.card.setOnClickListener {
                Log.v("MiApp", item.id.toString())
                OnClick(item)
            }
        }
    }
}