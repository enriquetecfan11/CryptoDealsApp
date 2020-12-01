package com.informatica404.coins3.start

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.informatica404.coins3.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.registerbutton


class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient
    val RC_SIGN_IN = 1
    val TAG = "miapp"
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = Firebase.auth
        // Initialize Firebase Firestore
        db = Firebase.firestore

        setup()

        registerbutton.setOnClickListener{
            val myIntent = Intent(this, register::class.java)
            this.startActivity(myIntent)

        }
    }


    fun navigateToHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun createUser(firstName: String, uid: String) {
        val newUser = Users()
        newUser.name = firstName

        db.collection("users").document(uid).set(newUser).addOnSuccessListener {
            navigateToHome()
        }.addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }

    }

    fun setup() {

        btlogin.setOnClickListener {
            if (email.text!!.isNotEmpty() && pass.text!!.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        email.text.toString(),
                        pass.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }

            Log.v("MIAPP", "ERES TONTISIMO")
        }
    }

    fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog = builder.create()

    }

    fun showHome(email: String, provider: ProviderType) {

        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }

        startActivity(homeIntent)
    }

}