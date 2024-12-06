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
import com.example.animation2.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(
            inflater, container, false
        )
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Список товаров"
        binding?.goToBasket?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, BasketFragment())
                .commit()
        }
        binding?.productsList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.productsList?.adapter = ProductsAdapter(Product.products)
    }
}