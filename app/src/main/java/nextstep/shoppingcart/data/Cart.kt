package nextstep.shoppingcart.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.model.CartItemInfo
import nextstep.shoppingcart.model.Product

object Cart {
    private val _items: SnapshotStateList<CartItemInfo> = mutableStateListOf()
    val items: List<CartItemInfo> get() = _items.toList()

    fun addOne(product: Product): List<CartItemInfo> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItemInfo(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: Product): List<CartItemInfo> {
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

    fun removeAll(product: Product): List<CartItemInfo> {
        _items.removeAll { it.product == product }
        return items
    }

    fun clear() { _items.clear() }
}
