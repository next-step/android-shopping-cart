package nextstep.shoppingcart.data.cart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import nextstep.shoppingcart.data.Product

object Cart {
    private val _items: SnapshotStateList<CartItem> = mutableStateListOf()
    val items: List<CartItem> get() = _items.toList()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product){
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

    fun itemAllClear() {
        _items.clear()
    }

    fun List<CartItem>.containProduct(product: Product): Boolean {
        return any { it.product == product }
    }
}