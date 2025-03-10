package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.data.model.CartItemEntity

class CartLocalDataSource {

    private val _itemsFlow = MutableStateFlow<LinkedHashMap<String, CartItemEntity>>(linkedMapOf())
    val items: Flow<LinkedHashMap<String, CartItemEntity>> = _itemsFlow.asStateFlow()

    fun update(itemEntity: CartItemEntity) {
        val currentMap = _itemsFlow.value.toMutableMap()
        val productId = itemEntity.product.id
        if (itemEntity.quantity < 1) {
            currentMap.remove(productId)
        } else {
            currentMap[productId] = itemEntity
        }

        _itemsFlow.value = LinkedHashMap(currentMap)
    }
}
