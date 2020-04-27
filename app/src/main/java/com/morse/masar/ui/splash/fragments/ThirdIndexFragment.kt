package com.morse.masar.ui.splash.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.cities.presentation.activity.CategoryActivity
import com.morse.masar.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_third_index.*
import kotlinx.android.synthetic.main.fragment_third_index.view.*


class ThirdIndexFragment : Fragment() , BaseFragment {
    lateinit var root : View
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_third_index, container, false)
        Log.i("morseee","Third Fragment onCreatView")
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        Glide.with(context!!).load(R.drawable.intro3e).override(600 , 600).into(root.mapImage)

        root?.discoverButton?.setOnClickListener {
            sharedPreferences?.edit()?.apply{
                this.putBoolean("isFirstTime" , true)
                this.commit()
            }
            startActivity(Intent(activity , CategoryActivity::class.java))
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        animateImage()
    }

    override fun animateImage() {
        if(mapImage != null) {
            scaleAnimation(mapImage)
            aplhaAnimation(root.thirdScreenText1)

        }
    }

    override fun onPause() {
        super.onPause()
        root.mapImage.visibility = View.INVISIBLE
        root.thirdScreenText1.visibility = View.INVISIBLE
        root.thirdScreenText2.visibility = View.INVISIBLE
        root.discoverButton.visibility = View.INVISIBLE
    }

    public fun scaleAnimation(view:View){
        var scaleAnime= android.view.animation.AnimationUtils.loadAnimation(context , R.anim.scale_from_origin)
        scaleAnime.interpolator = BounceInterpolator()
        scaleAnime.fillAfter = true // Need
        scaleAnime.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationEnd(p0: Animation?) {
                var animation = AnimationUtils.loadAnimation(context , R.anim.translate_anim)
                animation.interpolator = LinearOutSlowInInterpolator()
                locationMarker.startAnimation(animation)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationStart(p0: Animation?) {

            }
        })
        view.startAnimation(scaleAnime)
    }

    public fun getAlphaAnimation () : Animation {
        var aplhaAnime = AnimationUtils.loadAnimation(context , R.anim.text_alpha)
        aplhaAnime.interpolator = BounceInterpolator()
        aplhaAnime.fillAfter = true // Need
        return aplhaAnime
    }

    public fun aplhaAnimation(view:View){
        root.thirdScreenText1.visibility = View.VISIBLE
        var aplhaAnime = getAlphaAnimation()
        aplhaAnime.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                root.thirdScreenText2.visibility = View.VISIBLE
                var aplhaAnime = getAlphaAnimation()
                aplhaAnime.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationRepeat(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        root.discoverButton.visibility = View.VISIBLE
                        var aplhaAnime = getAlphaAnimation()
                        aplhaAnime.setAnimationListener(object :Animation.AnimationListener{
                            override fun onAnimationEnd(p0: Animation?) {

                            }

                            override fun onAnimationRepeat(p0: Animation?) {

                            }

                            override fun onAnimationStart(p0: Animation?) {

                            }
                        })
                        discoverButton?.startAnimation(getAlphaAnimation())
                    }

                    override fun onAnimationStart(p0: Animation?) {

                    }

                })
                thirdScreenText2.startAnimation(aplhaAnime)
            }

            override fun onAnimationStart(p0: Animation?) {

            }

        })
        view.startAnimation(aplhaAnime)
    }
}
