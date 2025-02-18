package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.data.model.ProductEntity

/**
 * Room과 같은 역할을 한다고 가정하고 작성했습니다.
 */
class CartLocalDataSource {

    // MutableList로 구현하면 Flow<List<CartItemEntity>>로 반환할 방법이 없어서 MutableStateFlow로 변경했습니다.
    private val _itemsFlow = MutableStateFlow<List<CartItemEntity>>(emptyList())
    val itemsFlow: Flow<List<CartItemEntity>> = _itemsFlow.asStateFlow()

    fun addOne(product: ProductEntity) {
        _itemsFlow.update { items ->
            val existingItem = items.find { it.product == product }
            if (existingItem == null) {
                items + CartItemEntity(product, 1)
            } else {
                items.map { item ->
                    if (item.product == product) {
                        item.copy(count = item.count + 1)
                    } else {
                        item
                    }
                }
            }
        }

    }

    fun removeOne(product: ProductEntity) {
        _itemsFlow.update { items ->
            items.find { it.product == product }?.let { item ->
                if (item.count > 1) {
                    items.map { current ->
                        if (current.product == product) {
                            current.copy(count = current.count + 1)
                        } else {
                            current
                        }
                    }
                } else {
                    items.filterNot { it.product == product }
                }
            } ?: items
        }

    }

    fun removeAll(product: ProductEntity) {
        _itemsFlow.update { items ->
            items.filterNot { it.product == product }
        }
    }
}
