package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

object CartBox {
    private val _value = mutableListOf<CartItem>().apply {
        addAll(CartItem.fixture)
    }
    val value: List<CartItem> get() = _value.toList()

    fun add(product: Product) {
        _value.add(CartItem(count = 1, product = product))
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

    fun reset(product: Product): List<CartItem> {
        val updatedItem = _value.map {
            if (it.product == product) {
                it.copy(count = 0)
            } else {
                it
            }
        }
        _value.clear()
        _value.addAll(updatedItem)
        return _value.toList()
    }

    fun clear() {
        _value.clear()
    }
}
