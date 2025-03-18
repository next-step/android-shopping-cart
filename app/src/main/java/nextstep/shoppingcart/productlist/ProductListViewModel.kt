package nextstep.shoppingcart.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.ProductsTestData
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.model.ProductListUiState
import nextstep.shoppingcart.productlist.model.ProductWithCartInfo

class ProductListViewModel(private val repository: Cart = Cart) :
    ViewModel() {

    val uiState: StateFlow<ProductListUiState> =
        repository.itemsFlow
            .map { cartItems ->
                // 빠른 cartItems 탐색을 위한 cartItemMap으로 변환
                mutableMapOf<String, Int>().apply {
                    cartItems.forEach {
                        this[it.product.productId] = it.count
                    }
                }
            }
            .combine(getInitialUiState()) { cartItemMap, currentUiState ->
                // 상품 리스트와 cartItemMap을 합쳐서 ProductWithCartInfo로 변환
                if (currentUiState is ProductListUiState.Success) {
                    currentUiState.copy(
                        products = currentUiState.products.map { productWithCartInfo ->
                            productWithCartInfo.copy(
                                cartCount = cartItemMap[productWithCartInfo.product.productId] ?: 0
                            )
                        }
                    )
                } else {
                    currentUiState
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ProductListUiState.Loading
            )

    private fun getInitialUiState(): StateFlow<ProductListUiState> =
        // ProductList를 API를 통해 성공적으로 받아오는 case
        flowOf(
            ProductListUiState.Success(ProductsTestData.productTestDataList.map {
                ProductWithCartInfo(it)
            })
        ).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ProductListUiState.Loading
        )

    fun addOne(product: Product) {
        repository.addOne(product)
    }

    fun removeOne(product: Product) {
        repository.removeOne(product)
    }
}
