package nextstep.shoppingcart.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.ProductsTestData
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.model.ProductListUiState
import nextstep.shoppingcart.productlist.model.ProductWithCartInfo

class ProductListViewModel(private val repository: Cart = Cart) :
    ViewModel() {

    private val _uiState: MutableStateFlow<ProductListUiState> =
        MutableStateFlow(ProductListUiState.Loading)
    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = ProductListUiState.Success(ProductsTestData.productTestDataList.map {
            ProductWithCartInfo(it)
        })
        viewModelScope.launch {
            repository.itemsFlow.collectLatest { cartItems ->
                val newMap = mutableMapOf<String, Int>()
                cartItems.forEach {
                    newMap[it.product.productId] = it.count
                }
                val currentUiState = _uiState.value
                if (currentUiState is ProductListUiState.Success) {
                    _uiState.value = currentUiState.copy(
                        products = currentUiState.products.map { productWithCartInfo ->
                            productWithCartInfo.copy(
                                cartCount = newMap[productWithCartInfo.product.productId] ?: 0
                            )
                        }
                    )
                }
            }
        }
    }

    fun addOne(product: Product) {
        repository.addOne(product)
    }

    fun removeOne(product: Product) {
        repository.removeOne(product)
    }
}
