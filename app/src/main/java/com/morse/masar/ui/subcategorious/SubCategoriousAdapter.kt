package com.morse.masar.ui.subcategorious

import android.view.LayoutInflater
import android.view.View
import com.morse.masar.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.morse.masar.ui.base.Listener
import com.morse.masar.ui.base.getRequestOptions
import com.morse.masar.ui.cities.model.entities.Item
import com.morse.masar.ui.cities.model.entities.Subcategoriou
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.country_templete.*

class SubCategoriousAdapter (private var listener: Listener<Subcategoriou>) : RecyclerView.Adapter<SubCategoriousAdapter.CountriesViewHolder>() {

    var countries = ArrayList<Subcategoriou> ()

    public fun submitSubCategorious (newCountries: ArrayList<Subcategoriou>){
        this.countries = newCountries
        this. notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        var layout = LayoutInflater.from(parent?.context)?.inflate(R.layout.country_templete , parent , false)
        return CountriesViewHolder(layout!!)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        Glide.with(holder?.containerView?.context!!).load(countries?.get(position)?.image).apply(
            getRequestOptions(25)).into(holder?.country_image)
        holder?.country_image?.setOnClickListener {
            listener?.clickOnItem(countries?.get(position) ,position )
        }
    }

    override fun getItemCount(): Int {
        return countries?.size
    }

    inner class CountriesViewHolder (override val containerView: View?): RecyclerView.ViewHolder(containerView!!)  , LayoutContainer {

    }

}