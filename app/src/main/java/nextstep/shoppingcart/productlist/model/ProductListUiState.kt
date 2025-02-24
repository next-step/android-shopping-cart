package nextstep.shoppingcart.productlist.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import nextstep.shoppingcart.model.Product

@Stable
sealed interface ProductListUiState {

    @Immutable
    data object Loading : ProductListUiState

    @Immutable
    data object Empty : ProductListUiState

    @Immutable
    data object Error : ProductListUiState

    @Immutable
    data class ProductList(
        val products: List<Product>,
    ) : ProductListUiState
}
