package com.example.easyerpsolution.ui.BottomNavigationToBuy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.databinding.BottomNavFragmentToBuyBinding
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.AddActivityAdapter
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.CategoriesAdapter
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.NewProductsAdapter


class BottomNavigationToBuyFragment : Fragment() {

    private var _binding: BottomNavFragmentToBuyBinding? = null

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var layoutManager_new_products: RecyclerView.LayoutManager? = null
    private var layoutManager_grid: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AddActivityAdapter.ViewHolder>? = null
    private var adapter_categories: RecyclerView.Adapter<CategoriesAdapter.ViewHolder>? = null
    private var adapter_new_products: RecyclerView.Adapter<NewProductsAdapter.ViewHolder>? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val TobuyViewModel =
            ViewModelProvider(this).get(BottomNavigationToBuyViewModel::class.java)

        _binding = BottomNavFragmentToBuyBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textToBuy
//        TobuyViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerview.layoutManager = layoutManager
        adapter = AddActivityAdapter()
        binding.recyclerview.adapter = adapter
        //grid layout.
        layoutManager_grid = GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, true)
        binding.recyclerviewCategories.layoutManager = layoutManager_grid
        adapter_categories = CategoriesAdapter()
        binding.recyclerviewCategories.adapter = adapter_categories

        //new products
        layoutManager_new_products = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewNewProducts.layoutManager = layoutManager_new_products
        adapter_new_products = NewProductsAdapter()
        binding.recyclerviewNewProducts.adapter = adapter_new_products
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}