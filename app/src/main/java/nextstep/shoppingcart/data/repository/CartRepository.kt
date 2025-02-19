package nextstep.shoppingcart.data.repository

import androidx.compose.runtime.mutableStateOf
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product

object CartRepository {
    private val _cartItems: MutableList<CartItem> = mutableListOf()

    private val _cart: Cart
        get() = Cart(_cartItems.toList())

    val cartState = mutableStateOf(_cart)

    fun addOne(product: Product): Cart {
        val item = _cartItems.find { it.product == product }
        if (item == null) {
            _cartItems.add(CartItem(product, 1))
        } else {
            val index = _cartItems.indexOf(item)
            _cartItems[index] = item.copy(count = item.count + 1)
        }
        return _cart
    }

    fun removeOne(product: Product): Cart {
        _cartItems.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _cartItems.indexOf(item)
                    _cartItems[index] = item.copy(count = item.count - 1)
                } else {
                    _cartItems.remove(item)
                }
            }
        return _cart
    }

    fun removeAll(product: Product): Cart {
        _cartItems.removeAll { it.product == product }
        return _cart
    }

    fun reset() {
        cartState.value = _cart
        _cartItems.clear()
    }
}
