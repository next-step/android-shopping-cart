package nextstep.shoppingcart.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

object Cart {
    private val _items: SnapshotStateList<CartItem> = mutableStateListOf()
    val items: List<CartItem> get() = _items.toList()

    private val _itemsFlow = MutableSharedFlow<List<CartItem>>(replay = 1)
    val itemsFlow: Flow<List<CartItem>> = _itemsFlow.asSharedFlow()

    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    private fun updateItemsFlow() {
        _itemsFlow.tryEmit(items)
    }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        updateItemsFlow()
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
        updateItemsFlow()
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        updateItemsFlow()
        return items
    }

    fun clearCartItem() {
        _items.clear()
    }
}
