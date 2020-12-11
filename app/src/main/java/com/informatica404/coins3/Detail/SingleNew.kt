package com.informatica404.coins3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.informatica404.coins3.models.Data
import com.informatica404.coins3.models.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_item.view.*
import kotlinx.android.synthetic.main.news_item.view.*

class SingleNew(private val data: ArrayList<Data>) : RecyclerView.Adapter<SingleNew.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Data) {

            Picasso.get().load(item.imageurl).into(itemView.img)
            itemView.tvtitular.text = item.title
            itemView.tvbody.text = HtmlCompat.fromHtml(item.body,HtmlCompat.FROM_HTML_MODE_COMPACT)

            //item.body.replace("[&#8230;]", "...")

        }

    }
}