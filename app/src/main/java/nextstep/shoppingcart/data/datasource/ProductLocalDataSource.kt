package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Room과 같은 역할을 한다고 가정하고 작성했습니다.
 */
class ProductLocalDataSource {

    private val _categoryFlow = MutableStateFlow<List<String>>(emptyList())
    val categoryFlow: Flow<List<String>> = _categoryFlow.asStateFlow()

    fun updateCategory(categories: List<String>) {
        _categoryFlow.value = categories
    }
}
