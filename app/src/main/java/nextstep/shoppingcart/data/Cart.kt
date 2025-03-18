package nextstep.shoppingcart.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

object Cart {

    private val items: ArrayList<CartItem> = ArrayList()

    private val _itemsFlow = MutableStateFlow<List<CartItem>>(emptyList())
    val itemsFlow: Flow<List<CartItem>> = _itemsFlow.asStateFlow()

    val totalPrice: Int get() = items.sumOf { it.totalPrice }

    private fun updateItemsFlow() {
        _itemsFlow.value = items.toList()
    }

    fun addOne(product: Product) {
        val item = items.find { it.product == product }
        if (item == null) {
            items.add(CartItem(product, 1))
        } else {
            val index = items.indexOf(item)
            items[index] = item.copy(count = item.count + 1)
        }
        updateItemsFlow()
    }

    fun removeOne(product: Product) {
        items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = items.indexOf(item)
                    items[index] = item.copy(count = item.count - 1)
                } else {
                    items.remove(item)
                }
            }
        updateItemsFlow()
    }

    fun removeAll(product: Product) {
        items.removeAll { it.product == product }
        updateItemsFlow()
    }

    fun clearCartItem() {
        items.clear()
    }
}
