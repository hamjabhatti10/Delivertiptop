package com.hamza.delivertiptop.ui.activities.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.databinding.ActivityMainBinding
import com.hamza.delivertiptop.ui.fragments.balanceFragment.BalanceFragment
import com.hamza.delivertiptop.ui.fragments.homeFragment.HomeFragment
import com.hamza.delivertiptop.ui.fragments.reportsFragment.ReportsFragment
import com.hamza.delivertiptop.ui.fragments.moreFragment.MoreFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        replaceFragment(HomeFragment())
        buttonNavigation()
    }

    private fun buttonNavigation() {
        mBinding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemHome -> replaceFragment(HomeFragment())
                R.id.itemReports -> replaceFragment(ReportsFragment())
                R.id.itemBalance -> replaceFragment(BalanceFragment())
                R.id.itemMore -> replaceFragment(MoreFragment())


            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
    }


