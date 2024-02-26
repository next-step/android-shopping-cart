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
}
