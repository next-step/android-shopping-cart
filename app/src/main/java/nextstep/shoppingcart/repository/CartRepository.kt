package nextstep.shoppingcart.repository

import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product

object CartRepository {
    private val _items: MutableList<CartItem> = mutableListOf()
    val items: List<CartItem> get() = _items.toList()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        return items
    }

    fun getItemCount(product: Product, cartItems: List<CartItem>): Int {
        val count = cartItems.find { it.product == product }?.count
        return count ?: 0
    }

    fun clear() {
        _items.clear()
    }
}