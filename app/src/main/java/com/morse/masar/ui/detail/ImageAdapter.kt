package com.morse.masar.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.morse.masar.R
import com.morse.masar.ui.base.getRequestOptions
import com.morse.masar.ui.cities.model.entities.Country
import com.morse.masar.ui.cities.presentation.fragment.CountriesAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.country_templete.*
import kotlinx.android.synthetic.main.image_templete.*

class ImageAdapter  : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    var imagesUrl = ArrayList<String> ()

    public fun submitCountries (newimagesUrl: ArrayList<String>){
        this.imagesUrl = newimagesUrl
        this. notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ImageViewHolder {
        var layout = LayoutInflater.from(parent?.context)?.inflate(R.layout.image_templete , parent , false)
        return ImageViewHolder(layout!!)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageViewHolder, position: Int) {
        Glide.with(holder?.containerView?.context!!).load(imagesUrl?.get(position)).apply(
            getRequestOptions(15)
        ).into(holder?.imageHolder)

    }

    override fun getItemCount(): Int {
        return imagesUrl?.size
    }

    inner class ImageViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!) , LayoutContainer{

    }
}