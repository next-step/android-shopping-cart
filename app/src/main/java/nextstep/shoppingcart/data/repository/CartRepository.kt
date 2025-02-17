package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product

object CartRepository {
    private val _cartItems: MutableList<CartItem> = mutableListOf()
    val cartItems: List<CartItem> get() = _cartItems.toList()

    val totalPrice: Int get() = _cartItems.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _cartItems.find { it.product == product }
        if (item == null) {
            _cartItems.add(CartItem(product, 1))
        } else {
            val index = _cartItems.indexOf(item)
            _cartItems[index] = item.copy(count = item.count + 1)
        }
        return cartItems
    }

    fun removeOne(product: Product): List<CartItem> {
        _cartItems.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _cartItems.indexOf(item)
                    _cartItems[index] = item.copy(count = item.count - 1)
                } else {
                    _cartItems.remove(item)
                }
            }
        return cartItems
    }

    fun removeAll(product: Product): List<CartItem> {
        _cartItems.removeAll { it.product == product }
        return cartItems
    }

    fun reset() {
        _cartItems.clear()
    }
}
