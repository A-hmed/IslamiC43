package com.route.islamic43.ui.screens.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic43.R
import com.route.islamic43.ui.screens.main.fragments.hadeth.HadethFragment
import com.route.islamic43.ui.screens.main.fragments.quran.QuranFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        showFragment(QuranFragment())
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.quranTab -> {
                    showFragment(QuranFragment())
                }

                R.id.hadethTab -> {
                    showFragment(HadethFragment())
                }

                R.id.sebhaTab -> {
                    Toast.makeText(this, "Task", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener false
                }

                R.id.radioTab -> {
                    Toast.makeText(this, "Not implemented yet", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener false
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}