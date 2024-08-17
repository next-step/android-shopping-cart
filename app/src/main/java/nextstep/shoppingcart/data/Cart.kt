package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product

interface Cart {
    val items: List<CartItem>
    val totalPrice: Int

    fun add(product: Product): List<CartItem>

    fun remove(product: Product): List<CartItem>

    fun removeAll(): List<CartItem>
}

class CartImpl : Cart {
    private val _items: MutableList<CartItem> = mutableListOf()
    override val items: List<CartItem>
        get() = _items

    override val totalPrice: Int
        get() = _items.sumOf { it.totalPrice }

    override fun add(product: Product): List<CartItem> {
        val find = _items.find { it.product == product }
        if (find != null) {
            val index = _items.indexOf(find)
            _items[index] = find.copy(quantity = find.quantity + 1)
        } else {
            _items.add(CartItem(product, 1))
        }
        return items
    }

    override fun remove(product: Product): List<CartItem> {
        val find = _items.find { it.product == product }
        if (find != null) {
            if (find.quantity > 1) {
                val index = _items.indexOf(find)
                _items[index] = find.copy(quantity = find.quantity - 1)
            } else {
                _items.remove(find)
            }
        }
        return items
    }

    override fun removeAll(): List<CartItem> {
        _items.clear()
        return items
    }
}
