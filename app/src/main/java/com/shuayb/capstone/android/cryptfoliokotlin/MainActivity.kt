package com.shuayb.capstone.android.cryptfoliokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById(R.id.bottom_nav_bar) as BottomNavigationView

        bottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {item->
            val selectedFragment : Fragment

            when (item.itemId) {
                R.id.nav_market -> {
                    selectedFragment = MarketsFragment()
                }
                R.id.nav_portfolio -> {
                    selectedFragment = PortfolioFragment()
                }
                R.id.nav_settings -> {
                    selectedFragment = SettingsFragment()
                }
                else -> {
                    return@OnNavigationItemSelectedListener false
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()

            return@OnNavigationItemSelectedListener true
        })
    }
}
