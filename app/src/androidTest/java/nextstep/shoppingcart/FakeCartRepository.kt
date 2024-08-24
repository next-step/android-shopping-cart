package nextstep.shoppingcart

import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.CartRepository
import nextstep.shoppingcart.model.Product

class FakeCartRepository : CartRepository {
    private val _cartItems = mutableListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems.toList()

    val totalPrice: Long get() = _cartItems.sumOf { it.totalPrice }
    fun clear() {
        _cartItems.clear()
    }
    fun setInitialItems(items: List<CartItem>) {
        _cartItems.clear()
        _cartItems.addAll(items)
    }

    override fun addOne(product: Product): List<CartItem> {
        val item = _cartItems.find { it.product == product }
        if (item == null) {
            _cartItems.add(CartItem(product, 1))
        } else {
            val index = _cartItems.indexOf(item)
            _cartItems[index] = item.copy(count = item.count + 1)
        }
        return cartItems
    }

    override fun removeOne(product: Product): List<CartItem> {
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

    override fun removeAll(product: Product): List<CartItem> {
        _cartItems.removeAll { it.product == product }
        return cartItems
    }
}