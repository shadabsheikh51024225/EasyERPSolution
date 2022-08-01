package com.example.easyerpsolution.ui.BottomNavigationToBuy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easyerpsolution.databinding.BottomNavFragmentToBuyBinding
import com.example.easyerpsolution.databinding.BottomNavigationGalFragmentBinding


class BottomNavigationToBuyFragment : Fragment() {

    private var _binding: BottomNavFragmentToBuyBinding? = null

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

        val textView: TextView = binding.textToBuy
        TobuyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}