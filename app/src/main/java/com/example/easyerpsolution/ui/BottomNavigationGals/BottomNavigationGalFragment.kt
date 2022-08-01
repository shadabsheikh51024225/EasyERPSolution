package com.example.easyerpsolution.ui.BottomNavigationGals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.BottomNavFragmentCategoriesBinding
import com.example.easyerpsolution.databinding.BottomNavigationGalFragmentBinding
import com.example.easyerpsolution.ui.BottomNavigationToBuy.BottomNavigationToBuyViewModel

class BottomNavigationGalFragment : Fragment() {

    private var _binding: BottomNavigationGalFragmentBinding? = null

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

        val textView: TextView = binding.textgal
        GalViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}