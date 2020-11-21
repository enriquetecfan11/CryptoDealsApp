package com.informatica404.coins3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_splash.*
import render.animations.*

class splash : AppCompatActivity() {

    val render = Render(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        disappear()
        nextActivity()

        Handler(Looper.getMainLooper()).postDelayed({
            logo.visibility = View.VISIBLE
        }, 500)

    }


    fun disappear(){
        render.setAnimation(Attention().Tada(logo))
        render.setDuration(600)
        render.start()
    }

    fun nextActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Login::class.java))
        }, 600)
    }

}
