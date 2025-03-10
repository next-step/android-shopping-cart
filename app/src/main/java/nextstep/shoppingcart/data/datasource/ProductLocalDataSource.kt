package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nextstep.shoppingcart.data.model.ProductEntity

/**
 * Room과 같은 역할을 한다고 가정하고 작성했습니다.
 */
class ProductLocalDataSource() {

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
        _itemsFlow.value = items
    }
}
