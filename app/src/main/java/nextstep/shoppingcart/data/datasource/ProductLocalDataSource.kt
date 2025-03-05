package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nextstep.shoppingcart.data.model.ProductEntity

/**
 * Room과 같은 역할을 한다고 가정하고 작성했습니다.
 */
class ProductLocalDataSource {

    // MutableList로 구현하면 Flow<List<CartItemEntity>>로 반환할 방법이 없어서 MutableStateFlow로 변경했습니다.
    private val _itemsFlow = MutableStateFlow<List<ProductEntity>>(emptyList())
    val itemsFlow: Flow<List<ProductEntity>> = _itemsFlow.asStateFlow()

    fun update(product: ProductEntity) {
        _itemsFlow.update { items ->
            items.map {
                if (it.id == product.id) {
                    product
                } else {
                    it
                }
            }
        }
    }

    fun replaceAll(items: List<ProductEntity>) {
        _itemsFlow.update { beforeItems ->
            items.map { item ->
                item.copy(
                    cartQuantity = beforeItems.firstOrNull { it.id == item.id }?.cartQuantity ?: 0
                )
            }
        }
    }
}
