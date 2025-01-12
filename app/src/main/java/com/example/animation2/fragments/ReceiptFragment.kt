package com.example.animation2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.animation2.Product.Companion.basketProducts
import com.example.animation2.databinding.FragmentReceiptBinding



class ReceiptFragment : Fragment() {
    private var binding: FragmentReceiptBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Чек за покупки"
        binding = FragmentReceiptBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sum = 0.0
        for (i in basketProducts)
            sum += i.price
        var receipt = "Список товаров:\n"
        for (i in basketProducts.indices) {
            receipt += basketProducts[i].toString() + "\n"
        }

        binding?.textViewTV?.text = "$receipt\nИтого: $sum денег"


    }

}