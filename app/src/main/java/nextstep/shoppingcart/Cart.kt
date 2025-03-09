package nextstep.shoppingcart

import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.list.model.Product

object Cart {
    private val _items: MutableList<CartItem> = mutableListOf()
    val items: List<CartItem> get() = _items.toList()
    
    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(productId: Int): List<CartItem> {
        _items.find { it.product.id == productId }
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

    fun removeAll(productId: Int): List<CartItem> {
        _items.removeAll { it.product.id == productId }
        return items
    }

    fun changeCount(productId: Int, count: Int) {
        _items.find { it.product.id == productId }
            ?.let { item ->
                if (count < 1) {
                    _items.remove(item)
                    return
                }
                val index = _items.indexOf(item)
                _items[index] = item.copy(count = count)
            }
    }
}
