package com.morse.masar.ui.youtube

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.base.getRequestOptions
import kotlinx.android.synthetic.main.fragment_video.view.*

class VideoFragment : DialogFragment() {

    lateinit var root : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_video, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loadThumbnils()
        registerActions()
        return root
    }

    private fun registerActions (){
        root?.playFab1?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/2sSbLu1MoKg")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab2?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/yC5NmAcAPGI")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab3?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/CIKuPf1uUbU")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab4?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/JIiBIgMJH28")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab5?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/v1VZJUfCYwg")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab6?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/uanOo0yTWko")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.playFab7?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://youtu.be/DqR9tUSGr00")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }

    }
    private fun loadThumbnils (){
        Glide.with(this).load("http://img.youtube.com/vi/2sSbLu1MoKg/0.jpg").apply(getRequestOptions(15)).into( root?.video1Image)
        Glide.with(this).load("http://img.youtube.com/vi/yC5NmAcAPGI/0.jpg").apply(getRequestOptions(15)).into( root?.video2Image)
        Glide.with(this).load("http://img.youtube.com/vi/CIKuPf1uUbU/0.jpg").apply(getRequestOptions(15)).into( root?.video3Image)
        Glide.with(this).load("http://img.youtube.com/vi/JIiBIgMJH28/0.jpg").apply(getRequestOptions(15)).into( root?.video4Image)
        Glide.with(this).load("http://img.youtube.com/vi/v1VZJUfCYwg/0.jpg").apply(getRequestOptions(15)).into( root?.video5Image)
        Glide.with(this).load("http://img.youtube.com/vi/uanOo0yTWko/0.jpg").apply(getRequestOptions(15)).into( root?.video6Image)
        Glide.with(this).load("http://img.youtube.com/vi/DqR9tUSGr00/0.jpg").apply(getRequestOptions(15)).into( root?.video7Image)
    }

}
