package com.morse.masar.ui.facbook

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

import com.morse.masar.R
import kotlinx.android.synthetic.main.fragment_facebook.view.*


class FacebookFragment : DialogFragment() {

    lateinit var root : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_facebook, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        registerActions()
        return root
    }
    fun registerActions (){
        root?.text1?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.facebook.com/egyptwanderers1/")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text2?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.facebook.com/SaveCairo/?ref=br_rs")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text3?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.facebook.com/savealexeg/?ref=br_rs")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text4?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.facebook.com/Follow-The-Trip-203564250216623/?ref=gs&fref=gs&hc_location=group")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text5?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.facebook.com/Post-office-136373080367433/?ref=gs&fref=gs&hc_location=group")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text6?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.facebook.com/Begin-of-the-story-1806747612728722/")
            }
            var chooser = Intent.createChooser(intent,"Select Player")
            if (intent?.resolveActivity(context?.packageManager!!)!=null){
                startActivity(chooser)
            }
            else {
                Toast.makeText(context , "Can`t find Player" , Toast.LENGTH_LONG).show ()
            }
        }
        root?.text7?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.facebook.com/Cosmopolitan-Alexandria-Villa-Itienrary-Campaign-Cavic-407564802991028/")
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

}
