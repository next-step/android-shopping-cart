package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.data.model.CartItemEntity

class CartLocalDataSource {

    private val _itemsFlow = MutableStateFlow<LinkedHashMap<String, CartItemEntity>>(linkedMapOf())
    val items: Flow<LinkedHashMap<String, CartItemEntity>> = _itemsFlow.asStateFlow()

    private val _cartTotalQuantity = MutableStateFlow(0)
    val cartTotalQuantity: Flow<Int> = _cartTotalQuantity.asStateFlow()

    fun update(itemEntity: CartItemEntity) {
        val currentMap = _itemsFlow.value.toMutableMap()
        val productId = itemEntity.product.id
        val previousQuantity = (currentMap.remove(productId)?.quantity ?: 0)

        if (itemEntity.quantity < 1) {
            _cartTotalQuantity.value -= previousQuantity
        } else {
            _cartTotalQuantity.value += itemEntity.quantity - previousQuantity
            currentMap[productId] = itemEntity
        }

        _itemsFlow.value = LinkedHashMap(currentMap)
    }
}
