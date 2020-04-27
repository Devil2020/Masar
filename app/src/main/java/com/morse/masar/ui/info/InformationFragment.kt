package com.morse.masar.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.facbook.FacebookFragment
import com.morse.masar.ui.youtube.VideoFragment
import kotlinx.android.synthetic.main.fragment_information.view.*

class InformationFragment : Fragment() {
    lateinit var root : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_information, container, false)
        Glide.with(this).load(R.drawable.facebook).override(200 , 200).into(root?.facebookKey)
        Glide.with(this).load(R.drawable.youtube).override(200 , 200).into(root?.youtubeKey)
        Glide.with(this).load(R.drawable.reference).override(200 , 200).into(root?.referenceKey)
        root?.youtubeValue?.setOnClickListener {
            var fra = VideoFragment()
            fra?.show(activity?.supportFragmentManager!! ,"video")

        }
        root?.facebookValue?.setOnClickListener {
            var a = FacebookFragment()
            a?.show(activity?.supportFragmentManager!! ,"video")

        }

        return root
    }

}
