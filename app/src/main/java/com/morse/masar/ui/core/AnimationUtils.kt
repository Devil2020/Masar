package com.morse.masar.ui.core

import android.content.Context
import android.view.ContextMenu
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.morse.masar.R
import kotlinx.android.synthetic.main.fragment_first_index.view.*
import kotlinx.android.synthetic.main.fragment_third_index.*
import kotlinx.android.synthetic.main.fragment_third_index.view.*

class AnimationUtils {

    public fun aplhaAnimation(context :Context , view: View , callBacks : ArrayList<View> = arrayListOf()  ){
        view.visibility = View.VISIBLE
        var aplhaAnime = AnimationUtils.loadAnimation(context , R.anim.text_alpha)
        aplhaAnime.interpolator = BounceInterpolator()
        aplhaAnime.fillAfter = true // Need
        view.startAnimation(aplhaAnime)
    }
    public fun scaleAnimation(view:View){

    }


}