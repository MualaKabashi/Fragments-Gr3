package com.cacttus.fragments_gr3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cacttus.fragments_gr3.R
import com.cacttus.fragments_gr3.databinding.ActivityInstagramBinding
import com.cacttus.fragments_gr3.fragments.HomeFragment
import com.cacttus.fragments_gr3.fragments.ProfileFragment
import com.cacttus.fragments_gr3.fragments.SearchFragment

class InstagramActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInstagramBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstagramBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var homeFragment = HomeFragment()
        var searchFragment = SearchFragment()
        var profileFragment = ProfileFragment()

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.search -> setCurrentFragment(searchFragment)
                R.id.person -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
        }.commit()
    }
}