package com.morse.masar.ui.splash.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morse.masar.ui.splash.fragments.FirstIndexFragment
import com.morse.masar.ui.splash.fragments.SecondIndexFragment
import com.morse.masar.ui.splash.fragments.ThirdIndexFragment

class SplashScreenAdapter (fragmentManager: FragmentActivity ,var length : Int):
    FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int {
        return length
    }

    override fun createFragment(position: Int): Fragment {
        if (length == 3) {
            if (position == 0) {
                return FirstIndexFragment()
            } else if (position == 1) {
                return SecondIndexFragment()
            }
            return ThirdIndexFragment()
        } else {
            return ThirdIndexFragment()
        }
    }
}