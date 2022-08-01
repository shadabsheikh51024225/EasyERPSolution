package com.example.easyerpsolution.ui.BottomNavigationMe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.BottomNavigationGalFragmentBinding
import com.example.easyerpsolution.databinding.BottomNavigationMeFragmentBinding
import com.example.easyerpsolution.ui.BottomNavigationToBuy.BottomNavigationToBuyViewModel

class BottomNavigationMeFragment : Fragment() {

    private var _binding: BottomNavigationMeFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val MeViewModel =
            ViewModelProvider(this).get(BottomNavigationMeViewModel::class.java)

        _binding = BottomNavigationMeFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMe
        MeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}