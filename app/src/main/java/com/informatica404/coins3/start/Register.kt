package com.informatica404.coins3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.informatica404.coins3.home.HomeFragment
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient
    val RC_SIGN_IN = 1
    val TAG = "miapp"
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth
        // Initialize Firebase Firestore
        db = Firebase.firestore

        btnSignUp.setOnClickListener {
            if (etEmail.text!!.isNotEmpty() && etPass.text!!.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        etEmail.text.toString(),
                        etPass.text.toString()
                ).addOnCompleteListener {

                    if (it.isSuccessful) {
                        createUser(etName.text.toString(),it.result?.user!!.uid )
                    } else {
                        showAlert()
                    }
                }
            }

        }
    }

    fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog = builder.create()

    }


    fun createUser(nombre: String, uid: String) {
        val newUser = Users()
        newUser.name= nombre

        db.collection("users").document(uid)
                .set(newUser)
                .addOnSuccessListener { document ->
                    Log.v(TAG, "createUserInFirestore:TODOFENOMENAL")
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener { e ->
                    Log.v(TAG, "createUserInFirestore:failure", e)
                }

    }

    fun navigateToHome() {
        startActivity(Intent(this, HomeFragment::class.java))
        finish()
    }
}