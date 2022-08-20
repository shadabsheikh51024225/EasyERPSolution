package com.example.easyerpsolution.ui.ProductDtails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.BottomNavFragmentCategoriesBinding
import com.example.easyerpsolution.databinding.FragmentCheckProductDetailsBinding
import com.example.easyerpsolution.ui.ProductDtails.Adapters.Checks_product_detail_card_adapter
import com.example.easyerpsolution.ui.ProductDtails.Adapters.ProductDetailsAdapterGrid

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Check_ProductDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class Check_ProductDetails : Fragment() {

    private var _binding: FragmentCheckProductDetailsBinding? = null
    private var layoutManager_checks_product_detais_grid: RecyclerView.LayoutManager? = null
    private var adapter_checks_product_details_grid: RecyclerView.Adapter<Checks_product_detail_card_adapter.ViewHolder>? =
        null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckProductDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //grid layout for right cards.
        layoutManager_checks_product_detais_grid =
            GridLayoutManager(requireContext(), 1, LinearLayoutManager.VERTICAL, true)
        binding.recyclerviewChecksProductDetailsGrid.layoutManager = layoutManager_checks_product_detais_grid
        adapter_checks_product_details_grid = Checks_product_detail_card_adapter()
        binding.recyclerviewChecksProductDetailsGrid.adapter = adapter_checks_product_details_grid
        return root
    }


}