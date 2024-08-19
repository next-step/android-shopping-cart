package nextstep.shoppingcart.data

import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product


object Cart : ShoppingCart {
    private val _items: MutableList<CartItem> = mutableListOf()
    override val items: List<CartItem> get() = _items.toList()

    override val totalPrice: Int
        get() = _items.sumOf { it.totalPrice }

    override fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(
                CartItem(product, 1)
            )
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    override fun removeOne(product: Product): List<CartItem> {
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

    override fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        return items
    }
}
