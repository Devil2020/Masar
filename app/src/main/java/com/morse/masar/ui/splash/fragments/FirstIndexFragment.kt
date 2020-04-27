package com.morse.masar.ui.splash.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.morse.masar.R
import com.morse.masar.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_first_index.*
import kotlinx.android.synthetic.main.fragment_first_index.view.*


class FirstIndexFragment : Fragment() , BaseFragment {
    lateinit var root : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_first_index, container, false)
        Glide.with(this).load(R.drawable.intro1).override(800 , 1000).into(root.logo)
        Log.i("isCreated", "FirstFragment Created once again")
        return root
    }

    override fun onStart() {
        super.onStart()
        Log.i("isCreated", "FirstFragment Started once again")
    }

    override fun onResume() {
        super.onResume()
        //animateImage()

    }

    public fun scaleAnimation(view:View){
        root.logo.visibility = View.VISIBLE
        var scaleAnime = AnimationUtils.loadAnimation(context , R.anim.scale_from_origin)
        scaleAnime.interpolator = BounceInterpolator()
        scaleAnime.fillAfter = true // Need
        view.startAnimation(scaleAnime)
    }

    public fun aplhaAnimation(view:View){
        root.firstScreenText1.visibility = View.VISIBLE
        var aplhaAnime = AnimationUtils.loadAnimation(context , R.anim.text_alpha)
        aplhaAnime.interpolator = BounceInterpolator()
        aplhaAnime.fillAfter = true // Need
        view.startAnimation(aplhaAnime)
    }

    override fun onPause() {
        super.onPause()
        //root.logo.visibility = View.INVISIBLE
        //root.firstScreenText1.visibility = View.INVISIBLE
    }

    override fun animateImage() {
        if(logo!=null) {
            scaleAnimation(logo)
            aplhaAnimation(firstScreenText1)

        }
    }
}
