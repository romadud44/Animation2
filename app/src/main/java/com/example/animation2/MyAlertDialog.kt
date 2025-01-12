package com.example.animation2

import android.app.AlertDialog
import android.content.Context
import android.widget.AdapterView
import android.widget.Toast

class MyAlertDialog {
    companion object{
        fun createDialog(context: Context, adapter: ProductsAdapter) =
            AdapterView.OnItemClickListener{_, _, position, _ ->
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Действие?")
                    .setMessage("Добавить в корзину?")
                    .setCancelable(true)
                    .setNegativeButton("Нет") {dialog, _ ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Да") {_, _ ->
                        val addProduct = adapter.getItemId(position)

                        Toast.makeText(context, "$addProduct", Toast.LENGTH_LONG).show()
                    }.create().show()

            }
    }
}