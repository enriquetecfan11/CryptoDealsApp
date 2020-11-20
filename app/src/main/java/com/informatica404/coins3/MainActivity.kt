package com.informatica404.coins3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    bottom_nav.setOnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.action_coins -> {
                goToFragment(CoinsFragment())
                true
            }
            R.id.action_news -> {
                goToFragment(NewsFragment())
                true
            }
            R.id.action_profile -> {
                goToFragment(ProfileFragment())
                true
            }
            R.id.action_home -> {
                goToFragment(HomeFragment())
                true
            }

            else -> false
        }
    }
    bottom_nav.selectedItemId = R.id.action_home
}

fun goToFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
}
}
