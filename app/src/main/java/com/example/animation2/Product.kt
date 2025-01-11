package com.example.animation2

data class Product(val name: String, val price: Double, val image: Int) {
    companion object {
        val products = mutableListOf(
            Product("Огурцы", 100.0, R.drawable.cucumbers),
            Product("Помидры", 150.0, R.drawable.tomato),
            Product("Морковь", 50.5, R.drawable.carrot),
            Product("Лук", 90.7, R.drawable.onion),
            Product("Мандарины", 299.9, R.drawable.tangerine),
            Product("Красные яблоки", 170.0, R.drawable.red_apple),
            Product("Зеленые яблоки", 150.0, R.drawable.green_apple),
            Product("Молоко", 75.5, R.drawable.milk),
            Product("Хлеб", 40.3, R.drawable.bread),
            Product("Капуста", 25.5, R.drawable.cabbage),
        )
    }

    override fun toString(): String {
        return "$name - $price денег"
    }
}