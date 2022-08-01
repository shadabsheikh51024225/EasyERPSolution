package com.example.easyerpsolution.ui.BottomNavigationNew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easyerpsolution.databinding.BottomNavFragmentNewBinding
import com.example.easyerpsolution.databinding.BottomNavigationMeFragmentBinding
import com.example.easyerpsolution.ui.BottomNavigationToBuy.BottomNavigationToBuyViewModel


class BottomNavigationNewFragment : Fragment() {

    private var _binding: BottomNavigationMeFragmentBinding? = null

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

        _binding = BottomNavigationMeFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMe
        NewViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}