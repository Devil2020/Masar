package com.morse.masar.ui.cities.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.morse.masar.R
import com.morse.masar.ui.base.Listener
import com.morse.masar.ui.categorious.CategoriousFragment
import com.morse.masar.ui.cities.domain.GetCountriesData
import com.morse.masar.ui.cities.model.CountriesRepository
import com.morse.masar.ui.cities.model.dataSource.AssestManager
import com.morse.masar.ui.cities.model.entities.Categorious
import com.morse.masar.ui.cities.model.entities.Country
import com.morse.masar.ui.cities.model.entities.PlaceResponse
import com.morse.masar.ui.subcategorious.SubCategoriousFragment
import kotlinx.android.synthetic.main.fragment_cities.view.*

class CitiesFragment : Fragment() , Listener<Categorious > {

    lateinit var categoryViewModelFactory : CountriesViewModelFactory
    lateinit var countriesUseCase : GetCountriesData
    lateinit var countriesViewModel  : CountriousViewModel
    lateinit var countriesAdapter : CountriesAdapter
    lateinit var root : View
    lateinit var placeResponse :PlaceResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_cities, container, false)
        countriesAdapter =
            CountriesAdapter(this as Listener<Categorious> )
        init()
        return root
    }

    override fun clickOnItem(t: Categorious,position : Int) {
        if (t?.items?.size > 0) {
            var categoriousFragment = CategoriousFragment()?.apply {
                arguments = Bundle()?.apply {
                    putParcelable("categorious", t)
                    putString("title", placeResponse?.countries?.get(position)?.name)
                }
            }

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentsContainer, categoriousFragment)
                ?.addToBackStack("CategoriousFragment")?.commit()
        }

        else {
            Toast.makeText(context , "Not Added Yet , Wait for Another Update" , Toast.LENGTH_LONG).show()
        }
    }
    fun init (){

        root?.countriesRecyclerView?.adapter = countriesAdapter
        countriesUseCase = GetCountriesData(CountriesRepository(AssestManager()))
        categoryViewModelFactory =
            CountriesViewModelFactory(
                context!!,
                "data.json",
                countriesUseCase
            )
        countriesViewModel = ViewModelProviders.of(this , categoryViewModelFactory).get(
            CountriousViewModel::class.java)
        countriesViewModel?.getCountries()
        countriesViewModel?.getCountries?.observe(this , object : Observer<PlaceResponse> {
            override fun onChanged(t: PlaceResponse?) {
                placeResponse = t!!
                countriesAdapter?.submitCountries(t?.countries!!)
            }
        })
    }

}
