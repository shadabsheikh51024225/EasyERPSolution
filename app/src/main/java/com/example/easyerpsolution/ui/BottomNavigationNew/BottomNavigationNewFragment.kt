package com.example.easyerpsolution.ui.BottomNavigationNew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.databinding.BottomNavigationNewStuffFragmentBinding
import com.example.easyerpsolution.ui.BottomNavigationNew.Adapters.BottomCardAdapters
import com.example.easyerpsolution.ui.BottomNavigationNew.Adapters.TopCardAdapters
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.CategoriesAdapter
import com.example.easyerpsolution.ui.BottomNavigationToBuy.BottomNavigationToBuyViewModel


class BottomNavigationNewFragment : Fragment() {

    private var _binding: BottomNavigationNewStuffFragmentBinding? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter_top_cards: RecyclerView.Adapter<TopCardAdapters.ViewHolder>? = null
    private var layoutManager_bottom: RecyclerView.LayoutManager? = null
    private var adapter_top_cards_bottom: RecyclerView.Adapter<BottomCardAdapters.ViewHolder>? =
        null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val NewViewModel =
            ViewModelProvider(this).get(BottomNavigationNewViewModel::class.java)

        _binding = BottomNavigationNewStuffFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //top card data settings.
        layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewNewActivity.layoutManager = layoutManager
        adapter_top_cards = TopCardAdapters()
        binding.recyclerviewNewActivity.adapter = adapter_top_cards

        //bottom card data settings.
        layoutManager_bottom = GridLayoutManager(context, 2, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewBottomNewActivity.layoutManager = layoutManager_bottom
        adapter_top_cards_bottom = BottomCardAdapters()
        binding.recyclerviewBottomNewActivity.adapter = adapter_top_cards_bottom
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}