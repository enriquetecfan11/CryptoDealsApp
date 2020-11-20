package com.informatica404.coins3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.informatica404.coins3.models.CryptoCoins
import kotlinx.android.synthetic.main.fragment_coins.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class CoinsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coins, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCoins = readJsonFromFile()
        val mAdapter = MainAdapter(listaCoins.data) {

        }
        recyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = mAdapter
    }


    fun readJsonFromFile(): CryptoCoins {
        var json = ""
        try {
            val url = "coins.json"
            val bufferedReader = BufferedReader(
                InputStreamReader(activity?.assets?.open(url))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }
            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val heroes = Gson().fromJson(json, CryptoCoins::class.java)
        return heroes
    }

}