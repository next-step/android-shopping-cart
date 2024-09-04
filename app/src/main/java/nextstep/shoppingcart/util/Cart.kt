package nextstep.shoppingcart.util

import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

object Cart {
    private val _items: MutableList<CartItem> = mutableListOf()
    val items: List<CartItem> get() = _items.toList()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product.id == product.id }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        _items.find { it.product.id  == product.id  }
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

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product.id  == product.id  }
        return items
    }

    fun cleatCart() {
        _items.clear()
    }
}