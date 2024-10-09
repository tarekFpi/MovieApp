package com.example.mydevesstream.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.mydevesstream.R
import com.example.mydevesstream.view.fragment.HomeFragment
import com.example.mydevesstream.view.fragment.SearchFragment
import com.example.mydevesstream.view.fragment.walletFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment())

        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.bottom_search -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.bottom_wallet -> {
                    loadFragment(walletFragment())
                    true
                }

                R.id.bottom_profile -> {
                    loadFragment(walletFragment())
                    true
                }
            }
            false
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout_home,fragment)
        transaction.commit()
    }
}