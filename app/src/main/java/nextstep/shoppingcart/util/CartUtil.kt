package nextstep.shoppingcart.util

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product


object CartUtil {
    private val _items = mutableStateListOf<Cart>()
    val items: SnapshotStateList<Cart> get() = _items

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<Cart> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(Cart(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: Product): List<Cart> {
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

    fun removeAll(product: Product): List<Cart> {
        _items.removeAll { it.product == product }
        return items
    }

}