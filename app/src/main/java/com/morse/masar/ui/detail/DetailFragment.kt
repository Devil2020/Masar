package com.morse.masar.ui.detail

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

import com.morse.masar.R
import com.morse.masar.ui.cities.model.entities.Item
import com.morse.masar.ui.cities.model.entities.Subcategoriou
import com.morse.masar.ui.core.checkIfNull
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy
import com.morse.masar.ui.favourite.model.localdb.SubcategoryDatabase
import kotlinx.android.synthetic.main.fragment_categorious.view.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.actionBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    lateinit var item : Subcategoriou
    lateinit var root : View
    lateinit var sliderImage : ImageAdapter
    lateinit var indoorImage : ImageAdapter
    var isExist : Boolean ?= null

    lateinit var ourLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable<Subcategoriou>("item") as Subcategoriou


    }

    private fun checkExistance (){
        CoroutineScope(Dispatchers.Main).launch {
            var length = SubcategoryDatabase.dataBaseBuilder?.getInstance(context!!).getDaoInteractor()
                ?.checkIfExists(item?.name)
            if (length >= 1){
                isExist = true
                root?.addToFavourite?.setImageDrawable(resources.getDrawable(R.drawable.ic_star_it))
            }
            else {
                isExist = false

                root?.addToFavourite?.setImageDrawable(resources.getDrawable(R.drawable.ic_unstar_it))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_detail, container, false)
        checkExistance()
        root?.actionBar?.title = item?.name
        root?.actionBar?.navigationIcon = resources?.getDrawable(R.drawable.ic_keyboard_backspace_black_24dp)
        ourLayoutManager = getCustomLayoutManager()
        root?.actionBar?.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        root?.locationValue?.setOnClickListener {
            var intent = Intent ()?.apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(item?.location)
            }

            var chooserIntent = Intent.createChooser(intent , "Open your Location")
            if (intent?.resolveActivity(context?.packageManager!!)!= null) {
                startActivity(chooserIntent)
            }
            else {
                Toast.makeText(context , "Please Check if you have at least Google Maps in your Phone",Toast.LENGTH_LONG).show()
            }

        }
        root ?.addToFavourite?.setOnClickListener {
            if (isExist == true){

                root?.addToFavourite?.setImageDrawable(resources?.getDrawable(R.drawable.ic_unstar_it))
                // delet item
                CoroutineScope(Dispatchers.IO)?.launch {
                    SubcategoryDatabase.dataBaseBuilder?.getInstance(context!!).getDaoInteractor()?.deletIntoDB(
                        item?.name
                    )
                }

                //Toast.makeText(context!! , "Your item ${item?.name} is added" , Toast.LENGTH_LONG).show()
            }
            else {
                root?.addToFavourite?.setImageDrawable(resources?.getDrawable(R.drawable.ic_star_it))

                CoroutineScope(Dispatchers.IO)?.launch {
                    SubcategoryDatabase.dataBaseBuilder?.getInstance(context!!).getDaoInteractor()?.insertIntoDB(
                        Subcategorioy(name = item?.name , image = item?.image , indoor = item?.indoor , location = item?.location , review = item?.review , slider_images = item?.slider_images ,type = item?.type , who_built = item?.who_built ,year = item?.year)
                    )
                }
                //Toast.makeText(context!! , "Your item ${item?.name} is removed" , Toast.LENGTH_LONG).show()
            }
        }
        sliderImage = ImageAdapter()
        indoorImage = ImageAdapter()
        bindData()
        return root
    }
    fun bindData () {

        item?.year ?.checkIfNull {
            root?.yearValue?.text = it
        }
        item?.who_built ?.checkIfNull {
            root?.howBuiltValue?.text = it
        }
        item?.type?.checkIfNull  {
            root?.styleValue?.text = it
        }
        root?.reviewValue?.text = item?.review
        root?.slideImageRecyclerView?.apply {
            layoutManager = ourLayoutManager
            adapter = sliderImage
        }
        root?.indoorRecyclerView?.apply {
            adapter = indoorImage
        }
        var snapHelper = PagerSnapHelper()
        snapHelper?.attachToRecyclerView(root?.slideImageRecyclerView )
        if (item?.indoor != null && item?.indoor?.size != 0){
            indoorImage?.submitCountries(getIndoors())
        }
        sliderImage?.submitCountries(getSliders())


    }

    private fun getIndoors () : ArrayList<String>{
        var indoors = ArrayList<String>()
        for (indoor in item?.indoor){
            indoors?.add(indoor?.indoor_img)
        }
        return indoors
    }

    private fun getSliders () : ArrayList<String>{
        var sliders = ArrayList<String>()
        for (slider in item?.slider_images){
            sliders?.add(slider?.image)
        }
        return sliders
    }

    private fun getCustomLayoutManager () : LinearLayoutManager {
        var layoutManager = LinearLayoutManager(context , RecyclerView.HORIZONTAL , false)
        return layoutManager
    }
}
