package com.morse.masar.ui.subcategorious

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide

import com.morse.masar.R
import com.morse.masar.ui.base.Listener
import com.morse.masar.ui.cities.model.entities.Item
import com.morse.masar.ui.cities.model.entities.Subcategoriou
import com.morse.masar.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_categorious.view.*
import kotlinx.android.synthetic.main.fragment_sub_categorious.view.*
import kotlinx.android.synthetic.main.fragment_sub_categorious.view.actionBar
import kotlinx.android.synthetic.main.fragment_sub_categorious.view.mapImage

class SubCategoriousFragment : Fragment() , Listener<Subcategoriou>{

    lateinit var root : View
    lateinit var subCategoryItem: Item
    lateinit var subCategoryAdapter : SubCategoriousAdapter
    lateinit var title : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subCategoryItem = arguments?.getParcelable<Item>("itemOfCategorious") as Item
        title = arguments?.getString("title","default")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_sub_categorious, container, false)
        root?.actionBar?.title = title
        root?.actionBar?.navigationIcon = resources?.getDrawable(R.drawable.ic_keyboard_backspace_black_24dp)
        root?.searchbar2?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var items = filter(p0?.toString()!!)
                subCategoryAdapter?.submitSubCategorious(items)
            }

        })
        root?.actionBar?.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        subCategoryAdapter = SubCategoriousAdapter(this as Listener<Subcategoriou>)
        if (subCategoryItem?.map_image?.isNotEmpty()){
            Glide.with(this).load(subCategoryItem?.map_image).override(LinearLayout.LayoutParams.MATCH_PARENT , 140).into(root?.mapImage)
        }
        root?.subCategoriousRecyclerview?.apply {
            adapter = subCategoryAdapter
            subCategoryAdapter?.submitSubCategorious(subCategoryItem?.subcategorious)
        }
        return root
    }

    override fun clickOnItem(t: Subcategoriou , position :Int) {
        var detail = DetailFragment()?.apply {
            arguments = Bundle()?.apply {
                putParcelable("item", t)
            }
        }
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentsContainer ,detail )?.addToBackStack("DetailFragment") ?.commit()

    }

    private fun filter (searchWord : String) =
        subCategoryItem?.subcategorious?.filter {
                item ->
            item?.name?.contains(searchWord)
        } as ArrayList<Subcategoriou>

}
