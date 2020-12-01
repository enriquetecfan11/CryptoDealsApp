package com.informatica404.coins3.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.informatica404.coins3.R
import com.informatica404.coins3.Users
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    val TAG = "MIAPP"
    val db = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentUser()
    }

    fun getCurrentUser() {
        val uid = auth.currentUser!!.uid

        Log.d(TAG, uid)

        db.collection("users").document(uid).get().addOnSuccessListener { document ->

            var user = document.toObject(Users::class.java)
            Log.d(TAG, "${user?.name}")

            this.txtemail.text = user?.name.toString()
            //this.txtemail.text = user?.email.toString()

            var email = auth.currentUser?.email
            txtname2.text = email.toString()

        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
    }



}