package com.morse.masar.ui.splash.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_second_index.*
import kotlinx.android.synthetic.main.fragment_second_index.view.*

class SecondIndexFragment : Fragment() , BaseFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var root : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_second_index, container, false)
        Log.i("morseee","Second Fragment onCreatView")
        Glide.with(context!!).load(R.drawable.intro2).override(1200 , 600).into(root.imageWithProblem)
        return root
    }

    override fun onResume() {
        super.onResume()
        animateImage()
    }

    override fun animateImage() {
        if(imageWithProblem != null) {
        scaleAnimation(root.imageWithProblem)
        aplhaAnimation(root.secondScreenText1)
    }
    }

    override fun onPause() {
        super.onPause()
        root.imageWithProblem.visibility = View.INVISIBLE
        root.secondScreenText1.visibility = View.INVISIBLE
        root.secondScreenText2.visibility = View.INVISIBLE
    }
    public fun scaleAnimation(view:View){
        var scaleAnime= android.view.animation.AnimationUtils.loadAnimation(context , R.anim.scale_from_origin)
        scaleAnime.interpolator = BounceInterpolator()
        scaleAnime.fillAfter = true // Need
        view.startAnimation(scaleAnime)
    }
    public fun aplhaAnimation(view:View){
        root.secondScreenText1.visibility = View.VISIBLE
        var aplhaAnime = AnimationUtils.loadAnimation(context , R.anim.text_alpha)
        aplhaAnime.interpolator = BounceInterpolator()
        aplhaAnime.fillAfter = true // Need
        aplhaAnime.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                root.secondScreenText1.visibility = View.VISIBLE
                var aplhaAnime = AnimationUtils.loadAnimation(context , R.anim.text_alpha)
                aplhaAnime.interpolator = BounceInterpolator()
                aplhaAnime.fillAfter = true // Need
                secondScreenText2.startAnimation(aplhaAnime)
            }

            override fun onAnimationStart(p0: Animation?) {

            }

        })
        view.startAnimation(aplhaAnime)
    }
}
