package com.example.easyerpsolution.ui.BottomNavigationToBuy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.databinding.BottomNavFragmentToBuyBinding
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.RecyclerAdapter


class BottomNavigationToBuyFragment : Fragment() {

    private var _binding: BottomNavFragmentToBuyBinding? = null

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
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

        adapter = RecyclerAdapter()
        binding.recyclerview.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}