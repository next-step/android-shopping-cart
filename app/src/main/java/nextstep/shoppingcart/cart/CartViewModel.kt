package nextstep.shoppingcart.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nextstep.shoppingcart.cart.model.CartUiState
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product


class CartViewModel(private val repository: Cart = Cart) :
    ViewModel() {

    val uiState: StateFlow<CartUiState> = repository.itemsFlow
        .map { cartItems ->
            CartUiState(repository.totalPrice, cartItems)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CartUiState(0, emptyList())
        )

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
