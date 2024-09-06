package nextstep.shoppingcart.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class CartItem(
    val product: Product,
    val count: Int,
    val isShowCountButton: Boolean
) {
    val totalPrice: Int get() = product.price * count
}

object Cart {
    private val _items: SnapshotStateList<CartItem> = mutableStateListOf()
    val items: List<CartItem> get() = _items

    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    fun addOne(product: Product) {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1, true))
        } else {
            val index = items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1, isShowCountButton = true)
        }
    }

    fun getCountByProductName(productName: String): Int {
        return _items.find { it.product.name == productName }?.count ?: 0
    }

    fun getButtonStateByProductName(productName: String): Boolean {
        return _items.find { it.product.name == productName }?.isShowCountButton ?: false
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

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        return _items
    }

    fun clear() {
        _items.clear()
    }
}
