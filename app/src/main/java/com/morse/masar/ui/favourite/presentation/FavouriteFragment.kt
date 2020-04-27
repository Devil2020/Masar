package com.morse.masar.ui.favourite.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.morse.masar.R
import com.morse.masar.ui.base.Listener
import com.morse.masar.ui.cities.model.entities.Categorious
import com.morse.masar.ui.cities.model.entities.Indoor
import com.morse.masar.ui.cities.model.entities.SliderImage
import com.morse.masar.ui.cities.model.entities.Subcategoriou
import com.morse.masar.ui.detail.DetailFragment
import com.morse.masar.ui.favourite.domain.GetAllFavouriteSubcategory
import com.morse.masar.ui.favourite.domain.GetNumOfFavourite
import com.morse.masar.ui.favourite.domain.InsertNewItem
import com.morse.masar.ui.favourite.model.FavouriteRepo
import com.morse.masar.ui.favourite.model.localdb.Subcategorioy
import com.morse.masar.ui.subcategorious.SubCategoriousAdapter
import kotlinx.android.synthetic.main.fragment_favourite.view.*

class FavouriteFragment : Fragment() , Listener<Subcategoriou> {

    lateinit var root : View
    lateinit var favouriteViewModel: FavouriteViewModel
    lateinit var repo: FavouriteRepo
    lateinit var adapter : SubCategoriousAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_favourite, container, false)
        repo = FavouriteRepo(context!!)
        adapter = SubCategoriousAdapter(this)
        root?.favouriteItems?.adapter = adapter
        var favouriteViewModelFactory = FavouriteSubCategoryFactory (context!! ,
            GetNumOfFavourite(repo) ,
            InsertNewItem(repo) ,
            GetAllFavouriteSubcategory(repo)
        )
        favouriteViewModel = ViewModelProviders.of(this , favouriteViewModelFactory)?.get(FavouriteViewModel::class.java)
        favouriteViewModel?.getNumOfFavouriteItems()
        favouriteViewModel?.numOfFavouriteItems?.observe(this , object  : Observer<Long> {
            override fun onChanged(t: Long?) {
                root?.progressIndicator?.visibility = View.INVISIBLE
                if (t!! > 0) {
                    root?.favouriteItems?.visibility = View.VISIBLE
                    favouriteViewModel?.getAllFavouriteSubCategorious()
                }
                else {
                    root?.noFavouriteItemsMessage?.visibility = View.VISIBLE
                }
            }
        })
        favouriteViewModel?.itemsOfFavourite?.observe(this , object : Observer<ArrayList<Subcategorioy>>{
            override fun onChanged(t: ArrayList<Subcategorioy>?) {
                Log.i("favouriteTest" , t?.get(0)?.name)
                root?.favouriteItems?.visibility = View.VISIBLE
               var result = t?.map {
                    Subcategoriou(it?.image, ArrayList<Indoor>(it?.indoor ) , it?.location , it?.name , it?.review , ArrayList<SliderImage>(it?.slider_images) , it?.type , it?.who_built , it?.year )
                }
                adapter?.submitSubCategorious(result as ArrayList<Subcategoriou>)
            }
        })
        return root
    }

    override fun clickOnItem(t: Subcategoriou, position: Int) {
        var detail = DetailFragment()?.apply {
            arguments = Bundle()?.apply {
                putParcelable("item", t)
            }
        }
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,detail )?.addToBackStack("DetailFragment") ?.commit()

    }

}
