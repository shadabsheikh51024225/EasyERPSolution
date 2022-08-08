package com.example.easyerpsolution.ui.BottomNavigationGals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.easyerpsolution.databinding.BottomNavigationGalFragmentBinding
import com.example.easyerpsolution.ui.BottomNavigationGals.Adapters.Staggered_grid_apater

class BottomNavigationGalFragment : Fragment() {

    private var _binding: BottomNavigationGalFragmentBinding? = null
    private var layoutManager_staggered: StaggeredGridLayoutManager? = null
    private var adapter_staggered: RecyclerView.Adapter<Staggered_grid_apater.ViewHolder>? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val GalViewModel =
            ViewModelProvider(this).get(BottomNavigationGalViewModel::class.java)

        _binding = BottomNavigationGalFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val LayoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL)

        //staggered date to grid
        layoutManager_staggered = StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerviewGirlsStaggered.layoutManager = layoutManager_staggered
        adapter_staggered = Staggered_grid_apater()
        binding.recyclerviewGirlsStaggered.adapter = adapter_staggered

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}