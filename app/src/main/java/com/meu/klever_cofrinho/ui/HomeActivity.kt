package com.meu.klever_cofrinho.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import com.meu.klever_cofrinho.R
import com.meu.klever_cofrinho.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationToTrackingFragmentIfNeeded(intent)

        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.navHostFragment))

        //Listener navHostFragment
        findNavController(R.id.navHostFragment).addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.homeFragment, R.id.criptoFragment, R.id.profileFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE
                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigationToTrackingFragmentIfNeeded(intent)
    }

    private fun navigationToTrackingFragmentIfNeeded(intent: Intent?) {
        if (intent?.action == "ACTION_SHOW_TRACKING_FRAGMENT") {
            findNavController(R.id.navHostFragment).navigate(R.id.action_global_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

private fun NavigationBarView.setupWithNavController(navController: NavController) {
    NavigationUI.setupWithNavController(this, navController)
}
