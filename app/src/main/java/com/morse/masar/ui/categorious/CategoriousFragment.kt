package com.morse.masar.ui.categorious

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.base.Listener
import com.morse.masar.ui.cities.model.entities.Categorious
import com.morse.masar.ui.cities.model.entities.Item
import com.morse.masar.ui.subcategorious.SubCategoriousAdapter
import com.morse.masar.ui.subcategorious.SubCategoriousFragment
import kotlinx.android.synthetic.main.fragment_categorious.view.*
import kotlinx.android.synthetic.main.fragment_categorious.view.actionBar
import kotlinx.android.synthetic.main.fragment_detail.view.*


class CategoriousFragment : Fragment() , Listener<Item>{
    lateinit var root : View
    lateinit var listOfItems : Categorious
    lateinit var categoriousAdapter : CategoriousAdapter
    lateinit var title : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOfItems = arguments?.getParcelable<Categorious>("categorious")!!
        title = arguments?.getString("title","default")!!
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_categorious, container, false)

        root?.actionBar?.title = title
        root?.actionBar?.navigationIcon = resources?.getDrawable(R.drawable.ic_keyboard_backspace_black_24dp)
        root?.actionBar?.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        root?.searchbar?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               var items = filter(p0?.toString()!!)
               categoriousAdapter?.submitCategorious(items)
            }

        })
        categoriousAdapter = CategoriousAdapter(this as Listener<Item>)
        root?.categoriousRecyclerview?.apply {
            adapter = categoriousAdapter
        }
        if (!listOfItems?.map_image?.equals("")){
            Glide.with(this).load(listOfItems?.map_image)?.override(Int.MAX_VALUE,130)
        }
        categoriousAdapter?.submitCategorious(listOfItems?.items)
        return root
    }

    override fun clickOnItem(t: Item , position : Int) {
        var subCategory = SubCategoriousFragment()?.apply {
            arguments = Bundle()?.apply {
                putParcelable("itemOfCategorious", t)
                putString("title" , listOfItems?.items?.get(position)?.name)
            }
        }
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,subCategory )?.addToBackStack("SubCategoriousFragment") ?.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater?.inflate(R.menu.search_menu , menu)
        root?.actionBar?.inflateMenu(R.menu.search_menu)
        var menuItem = menu?.findItem(R.id.app_bar_search)
        var searchView = menuItem?.actionView as SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun filter (searchWord : String) =
        listOfItems?.items?.filter {
            item ->
            item?.name?.contains(searchWord)
        } as ArrayList<Item>
}
