package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

object CartBox {
    private val _value = mutableListOf<CartItem>()
    val value: List<CartItem> get() = _value.toList()

    val totalPrice: Int
        get() = _value.sumOf {
            it.count.times(other = it.product.price)
        }

    fun add(product: Product) {
        _value.add(CartItem(product = product))
        val updatedItem = _value
            .groupBy {
                cartItem -> cartItem.product.id
            }
            .map { (_, value) ->
                CartItem(count = value.sumOf { it.count }, product = value.first().product)
            }
        _value.clear()
        _value.addAll(updatedItem)
    }

    fun removed(product: Product): List<CartItem> {
        _value.find { it.product == product }
            ?.let(_value::remove)
        return _value.toList()
    }
}
