package nextstep.shoppingcart.cart.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product


class CartViewModel(private val repository: Cart = Cart) :
    ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState(0, emptyList()))
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.itemsFlow.collectLatest { cartItems ->
                _uiState.value = CartUiState(repository.totalPrice, cartItems)
            }
        }
    }

    fun addOne(product: Product) {
        repository.addOne(product)
    }

    fun removeOne(product: Product) {
        repository.removeOne(product)
    }

    fun removeAll(product: Product) {
        repository.removeAll(product)
    }
}
