package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animation2.Product
import com.example.animation2.ProductsAdapter
import com.example.animation2.R
import com.example.animation2.databinding.FragmentBasketBinding
import com.example.animation2.databinding.FragmentListBinding


class BasketFragment : Fragment() {
    private var binding: FragmentBasketBinding? = null
    var basketAdapter = ProductsAdapter(Product.basketProducts)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Корзина"
        binding?.goToReceipt?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, ReceiptFragment())
                .commit()
        }
        binding?.basketListRV?.setHasFixedSize(true)
        binding?.basketListRV?.layoutManager = LinearLayoutManager(requireContext())
        binding?.basketListRV?.adapter = basketAdapter

    }


}