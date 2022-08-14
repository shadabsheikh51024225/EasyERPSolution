package com.example.easyerpsolution.ui.BottomNavigationMe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.BottomNavFragmentMeBinding
import com.example.easyerpsolution.ui.BottomNavigationMe.Adapters.ListAdapaterUser
import com.example.easyerpsolution.ui.UserActivites.Coupons.CouponsActivity
import com.example.easyerpsolution.ui.UserActivites.Coupons.MyOrders
import com.example.easyerpsolution.ui.UserActivites.Coupons.PurseActivity


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
            "Coupons", "Purse", "Points", "My orders",
            "Wish list",
            "Adjustments",
            "Comments",
            "Return",
            "Support"
        )
        val listImage = arrayOf<Int>(
            R.drawable.me_cupons_three,
            R.drawable.me_purse_three,
            R.drawable.me_points,
            R.drawable.me_my_orders_three,
            R.drawable.me_wish_list_three,
            R.drawable.me_adjustment_thee,
            R.drawable.me_comments_three,
            R.drawable.me_returen_three,
            R.drawable.me_support_three
        )
        val myListAdapter = ListAdapaterUser(requireActivity(), text_list, listImage)
        binding.meRecyclerviewList.adapter = myListAdapter

        binding.meRecyclerviewList.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                // your code
                if (position.equals(0))
                {
                    val i = Intent(context,CouponsActivity::class.java)
                    startActivity(i)
                }
                if (position.equals(1))
                {
                    val i = Intent(context,PurseActivity::class.java)
                    startActivity(i)
                }
                if (position.equals(3))
                {
                    val i = Intent(context,MyOrders::class.java)
                    startActivity(i)
                }

            }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}