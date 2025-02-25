package nextstep.shoppingcart.cart.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.model.Product


class CartViewModel(private val repository: Cart = Cart) :
    ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState(0, emptyList()))
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = CartUiState(repository.totalPrice, repository.items)
    }

    fun addOne(product: Product) {
        repository.addOne(product)
        _uiState.value = CartUiState(repository.totalPrice, repository.items)
    }

    fun removeOne(product: Product) {
        repository.removeOne(product)
        _uiState.value = CartUiState(repository.totalPrice, repository.items)
    }

    fun removeAll(product: Product) {
        repository.removeAll(product)
        _uiState.value = CartUiState(repository.totalPrice, repository.items)
    }
}
