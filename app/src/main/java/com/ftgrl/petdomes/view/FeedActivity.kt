package com.ftgrl.petdomes.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ftgrl.petdomes.*
import com.ftgrl.petdomes.cerceve.*
import com.ftgrl.petdomes.databinding.ActivityFeedBinding
import com.google.android.material.bottomnavigation.BottomNavigationView




class FeedActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityFeedBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //recyclerview


        loadFragment(HomeFragment())
        bottomNavigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_search -> {
                    loadFragment(SearchFragment())
                    true
                }

                R.id.nav_add -> {
                    loadFragment(AddFragment())
                    true
                }
                R.id.nav_notifications -> {
                    loadFragment(NotificationsFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> throw IllegalStateException("Someone forgot to add enough fragment cases to 'when' clause!")
            }
        }


        }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.cercevekapsayici,fragment)
        transaction.commit()
    }



}
