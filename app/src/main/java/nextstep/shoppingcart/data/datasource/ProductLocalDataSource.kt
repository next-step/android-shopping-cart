package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.data.model.ProductEntity

/**
 * Room과 같은 역할을 한다고 가정하고 작성했습니다.
 */
class ProductLocalDataSource {

    private val _itemsFlow = MutableStateFlow<List<ProductEntity>>(emptyList())
    val itemsFlow: Flow<List<ProductEntity>> = _itemsFlow.asStateFlow()

    private val _categoryFlow = MutableStateFlow<List<String>>(emptyList())
    val categoryFlow: Flow<List<String>> = _categoryFlow.asStateFlow()

    fun replaceAllItems(items: List<ProductEntity>) {
        _itemsFlow.value = items
    }

    fun updateCategory(categories: List<String>) {
        _categoryFlow.value = categories
    }
}
