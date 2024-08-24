package nextstep.shoppingcart.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}

object Cart {
    private val _items = MutableStateFlow<List<CartItem>>(emptyList())
    val items = _items.asStateFlow()

    val totalPrice: Int get() = _items.value.sumOf { it.totalPrice }

    fun addOne(product: Product) {
        val currentItems = _items.value
        val item = currentItems.find { it.product == product }
        val newItems = if (item == null) {
            currentItems + CartItem(product, 1)
        } else {
            currentItems.map {
                if (it.product == product) it.copy(count = it.count + 1) else it
            }
        }
        _items.value = newItems
    }

    fun removeOne(product: Product) {
        val currentItems = _items.value
        val newItems = currentItems.mapNotNull { item ->
            when {
                item.product != product -> item
                item.count > 1 -> item.copy(count = item.count - 1)
                else -> null
            }
        }
        _items.value = newItems
    }

    fun removeAll(product: Product) {
        _items.value = _items.value.filter { it.product != product }
    }
}
