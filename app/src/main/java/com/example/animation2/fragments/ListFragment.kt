package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animation2.Product
import com.example.animation2.ProductsAdapter
import com.example.animation2.R
import com.example.animation2.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    var adapter = ProductsAdapter(Product.products)
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
        binding?.productsList?.setHasFixedSize(true)
        binding?.productsList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.productsList?.adapter = adapter


        adapter.setOnProductClickListener(object :
            ProductsAdapter.OnProductClickListener {
            override fun onProductClick(product: Product, position: Int) {
//                MyAlertDialog.createDialog(requireContext(), adapter)
                /**
                 * Не получилось реализовать AlertDialog отдельным классом, почему-то не хотел работать :(
                 */
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Действие?")
                    .setMessage("Добавить ${adapter.getItem(position).name} в корзину?")
                    .setCancelable(true)
                    .setNegativeButton("Нет") { dialog, _ ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Да") { _, _ ->
                        val addProduct = adapter.getItem(position)
                        Product.basketProducts.add(addProduct)
                        Toast.makeText(
                            requireContext(),
                            "${addProduct.name} добавлен в корзину",
                            Toast.LENGTH_LONG
                        ).show()
                    }.create().show()
            }
        })
    }
}