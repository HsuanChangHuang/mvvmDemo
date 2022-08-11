package com.ray.mvvmdemo.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ray.mvvmdemo.R
import com.ray.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
        setSupportActionBar(binding.toolbarMain)

        binding.toolbarMain.setNavigationOnClickListener {
            navController.popBackStack()
        }
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.flightListFragment -> {
                    showToolbarBackButton(false)
                }
                R.id.flightDetailFragment -> {
                    showToolbarBackButton(true)
                }
            }
        }
    }

    private fun showToolbarBackButton(show: Boolean){
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
        supportActionBar?.setDisplayShowHomeEnabled(show)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val label = navController.currentDestination?.id
            return if (label == R.id.flightDetailFragment){
//                navController.popBackStack()
                false
            }else{
                super.onKeyDown(keyCode, event)
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}