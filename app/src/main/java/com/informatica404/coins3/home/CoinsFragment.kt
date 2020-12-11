package com.informatica404.coins3.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.informatica404.coins3.ApiCoins.ApiRest
import com.informatica404.coins3.DataHolder
import com.informatica404.coins3.DetailCoin
import com.informatica404.coins3.R
import com.informatica404.coins3.SingleCoin
import com.informatica404.coins3.models.Coins
import com.informatica404.coins3.models.CoinsItem
import kotlinx.android.synthetic.main.fragment_coins.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CoinsFragment : Fragment() {

    val TAG = "MiApp"
    var data: ArrayList<CoinsItem> = ArrayList()
    private var adapter: SingleCoin? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coins, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SingleCoin(data){ mycointitem ->
           DataHolder.coin = mycointitem
          activity?.startActivity(Intent(activity, DetailCoin::class.java))
        }

        val mLayoutManager = GridLayoutManager(context, 1)
        recyclerview.layoutManager = mLayoutManager
        recyclerview.adapter = adapter


        getGenres()



    }

    private fun getGenres() {
        val call = ApiRest.initService().getCoins()
        call.enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    Log.i(TAG, body.toString())
                    data.clear()
                    data.addAll(body)
                    // Imprimir aqui el listado
                    adapter?.notifyDataSetChanged()
                } else {
                    Log.i(TAG, "Hola")
                }
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                Log.i(TAG, t.toString())
                Log.i(TAG, t.message.toString())

            }
        })
    }
}