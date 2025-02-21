package nextstep.shoppingcart.data.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product

object CartRepository {
    private val _cartItems: MutableList<CartItem> = mutableListOf()

    private val _cart: Cart
        get() = Cart(_cartItems.toList())

    var cartState by mutableStateOf(_cart)
        private set

    fun addOne(product: Product) {
        val item = _cartItems.find { it.product == product }
        if (item == null) {
            _cartItems.add(CartItem(product, 1))
        } else {
            val index = _cartItems.indexOf(item)
            _cartItems[index] = item.copy(count = item.count + 1)
        }
        cartState = _cart
    }

    fun removeOne(product: Product) {
        _cartItems.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _cartItems.indexOf(item)
                    _cartItems[index] = item.copy(count = item.count - 1)
                } else {
                    _cartItems.remove(item)
                }
            }
        cartState = _cart
    }

    fun removeAll(product: Product) {
        _cartItems.removeAll { it.product == product }
        cartState = _cart
    }
}
