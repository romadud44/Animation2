package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.animation2.Product
import com.example.animation2.Product.Companion.products
import com.example.animation2.R
import com.example.animation2.databinding.FragmentReceiptBinding
import com.example.animation2.databinding.FragmentStartBinding


class ReceiptFragment : Fragment() {
    private var binding: FragmentReceiptBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Чек за покупки"
        binding = FragmentReceiptBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var receipt = "Список товаров:\n"
        for (i in products.indices) {
          receipt = receipt + products[i].toString() + "\n"
        }

        binding?.textViewTV?.text = receipt
    }

}