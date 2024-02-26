package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

object CartBox {
    private val _value = mutableListOf<CartItem>()
    val value: List<CartItem> get() = _value.toList()

    fun add(product: Product) {
        _value.clear()
        _value.map { cart ->
            if (cart.product == product) {
                cart.copy(count = cart.count.plus(other = 1))
            } else {
                cart
            }
        }.let(_value::addAll)
    }
}
