package nextstep.shoppingcart.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class CartItem(val product: Product, val count: Int) {
    val totalPrice: Int get() = product.price * count
}

object Cart {
    private val _items = mutableStateListOf<CartItem>()
    val items: SnapshotStateList<CartItem> get() = _items

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product) {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
    }

    fun removeOne(product: Product) {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
    }

    fun removeAll(product: Product) {
        _items.removeAll { it.product == product }
    }

    fun getCount(product: Product): Int {
        return _items.find { it.product == product }?.count ?: 0
    }

    fun clearAll() {
        _items.clear()
    }
}
