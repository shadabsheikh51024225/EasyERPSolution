package com.example.easyerpsolution.ui.BottomNavigationMe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.BottomNavFragmentMeBinding
import com.example.easyerpsolution.ui.BottomNavigationMe.Adapters.ListAdapaterUser


class BottomNavigationMeFragment : Fragment() {

    private var _binding: BottomNavFragmentMeBinding? = null

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

        _binding = BottomNavFragmentMeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val text_list = arrayOf<String>(
            "Coupons,Points,Purse,My orders",
            "Wish list",
            "Adjustments",
            "Comments",
            "Return",
            "Support"
        )
        val listImage = arrayOf<Int>(
            R.drawable.me_cupons_three,
            R.drawable.me_purse_three,
            R.drawable.me_purse_three,
            R.drawable.me_my_orders_three,
            R.drawable.me_wish_list_three,
            R.drawable.me_adjustment_thee,
            R.drawable.me_comments_three,
            R.drawable.me_returen_three,
            R.drawable.me_support_three
        )
        val myListAdapter = ListAdapaterUser(requireActivity(),text_list,listImage)
        binding.meRecyclerviewList.adapter = myListAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}