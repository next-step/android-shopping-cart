package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

object CartBox {
    private val _value = mutableListOf<CartItem>()
    val value: List<CartItem> get() = _value.toList()

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

    fun remove(product: Product) {
        val updatedItem = _value.map {
            if (it.product == product) {
                it.copy(count = it.count.minus(other = 1))
            } else {
                it
            }
        }
        _value.clear()
        _value.addAll(updatedItem)
    }

    fun removed(product: Product): List<CartItem> {
        _value.find { it.product == product }
            ?.let(_value::remove)
        return _value.toList()
    }

    fun clear() {
        _value.clear()
    }
}
