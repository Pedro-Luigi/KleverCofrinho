package com.meu.klever_cofrinho.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.meu.klever_cofrinho.ui.fragment.CriptoFragment
import com.meu.klever_cofrinho.ui.fragment.HomeFragment
import com.meu.klever_cofrinho.ui.fragment.ProfileFragment

class TabAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> CriptoFragment()
            else -> ProfileFragment()
        }
    }
}