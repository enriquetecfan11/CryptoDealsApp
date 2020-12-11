package com.informatica404.coins3.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.informatica404.coins3.ApiCoins.ApiRest
import com.informatica404.coins3.R
import com.informatica404.coins3.Users
import com.informatica404.coins3.models.Coins
import com.informatica404.coins3.models.CoinsItem
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    val TAG = "MIAPP"
    val db = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentUser()
        getGenres()

    }

    fun getCurrentUser() {
        val uid = auth.currentUser!!.uid

        Log.d(TAG, uid)

        db.collection("users").document(uid).get().addOnSuccessListener { document ->

            var user = document.toObject(Users::class.java)
            Log.d(TAG, "${user?.name}")
            // this.txtusername.text = user?.name.toString()

        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
    }

    private fun getGenres() {
        val call = ApiRest.initService().getCoins()
        call.enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    Log.i(TAG, body.toString())

                    printhome(body)

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

    private fun printhome(data: ArrayList<CoinsItem>) {

        var bitcoin = data.find {
            it.id == "bitcoin"
        }

        pricebtc.text = "Price: " + bitcoin?.current_price.toString() + " €"
        btchange.text = "Price change in 24 Hours: " + bitcoin?.price_change_24h.toString() + " €"

        var ethereum = data.find {
            it.id == "ethereum"
        }

        priceth.text = "Price: " + ethereum?.current_price.toString() + " €"
        ethchange.text = "Price change in 24 Hours: " + ethereum?.price_change_24h.toString() + " €"

    }


}