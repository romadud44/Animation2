package com.example.animation2

data class Product(val name: String, val price: Double, val image: Int) {
    companion object {
        val products = mutableListOf(
            Product("Огурцы", 100.0, R.drawable.cucumbers),
            Product("Помидры", 150.0, R.drawable.cucumbers),
            Product("Морковь", 50.5, R.drawable.cucumbers),
            Product("Лук", 90.7, R.drawable.cucumbers),
            Product("Мандарины", 299.9, R.drawable.cucumbers)
        )
    }
}