package com.shuayb.capstone.android.cryptfoliokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shuayb.capstone.android.cryptfoliokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var marketsFragment : MarketsFragment
    private lateinit var portfolioFragment : PortfolioFragment
    private lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initSetup()
    }

    private fun initSetup() {
        marketsFragment = MarketsFragment()
        portfolioFragment = PortfolioFragment()
        settingsFragment = SettingsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, marketsFragment).commit()

        mBinding.bottomNavBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {item->
            val selectedFragment : Fragment

            when (item.itemId) {
                R.id.nav_market -> {
                    selectedFragment = marketsFragment
                }
                R.id.nav_portfolio -> {
                    selectedFragment = portfolioFragment
                }
                R.id.nav_settings -> {
                    selectedFragment = settingsFragment
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
