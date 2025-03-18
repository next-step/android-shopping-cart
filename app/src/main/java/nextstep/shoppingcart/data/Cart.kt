package nextstep.shoppingcart.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product

object Cart {

    private val _itemsFlow = MutableStateFlow<List<CartItem>>(emptyList())
    val itemsFlow: Flow<List<CartItem>> = _itemsFlow.asStateFlow()

    val totalPrice: Int get() = _itemsFlow.value.sumOf { it.totalPrice }

    fun addOne(product: Product) {
        _itemsFlow.update { currentItems ->
            val item = currentItems.find { it.product == product }
            if (item == null) {
                currentItems + CartItem(product, 1)
            } else {
                currentItems.map {
                    if (it.product == product) {
                        it.copy(count = it.count + 1)
                    } else {
                        it
                    }
                }
            }
        }
    }

    fun removeOne(product: Product) {
        _itemsFlow.update { currentItems ->
            currentItems.find { it.product == product }?.let { item ->
                if (item.count > 1) {
                    currentItems.map {
                        if (it.product == product) {
                            it.copy(count = it.count - 1)
                        } else {
                            it
                        }
                    }
                } else {
                    currentItems.filter { it.product != product }
                }
            } ?: currentItems
        }
    }

    fun removeAll(product: Product) {
        _itemsFlow.update { currentItems ->
            currentItems.filter { it.product != product }
        }
    }

    fun clearCartItem() {
        _itemsFlow.value = emptyList()
    }
}
