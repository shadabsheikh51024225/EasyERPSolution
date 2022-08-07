package com.example.easyerpsolution.ui.BottomNavigationCategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.databinding.BottomNavFragmentCategoriesBinding
import com.example.easyerpsolution.ui.BottomNavigationCategories.Adapters.CategoriesCardAdapter

import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.AddActivityAdapter
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.CategoriesAdapter


class BottomNavigationCategoriesFragment : Fragment() {

    private var _binding: BottomNavFragmentCategoriesBinding? = null
    private var layoutManager_right_cards: RecyclerView.LayoutManager? = null
    private var adapter_right_cards: RecyclerView.Adapter<CategoriesCardAdapter.ViewHolder>? = null


    lateinit var ListView: ListView
    private val textData = arrayOf(
        "Recommended",
        "News",
        "Trends",
        "Rebate",
        "Clothing",
        "Dresses",
        "Beachwear",
        "Lingerie & Lounge",
        "Denim",
        "Sportswear",
        "Shoes",
        "Handbag",
        "Imitation Jewelry",
        "shoes"
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CategoriesViewModel =
            ViewModelProvider(this).get(BottomNavigationCategoriesViewModel::class.java)

        _binding = BottomNavFragmentCategoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //left side list data settings.
        val ArrayAdapter: ArrayAdapter<*>
        ArrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, textData)
        binding.categoriesRecyclerviewList.adapter = ArrayAdapter
        binding.categoriesRecyclerviewList.choiceMode = android.widget.ListView.CHOICE_MODE_SINGLE

        //grid layout for right cards.
        layoutManager_right_cards = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, true)
        binding.recyclerviewCategoriesRightCards.layoutManager = layoutManager_right_cards
        adapter_right_cards = CategoriesCardAdapter()
        binding.recyclerviewCategoriesRightCards.adapter = adapter_right_cards



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}