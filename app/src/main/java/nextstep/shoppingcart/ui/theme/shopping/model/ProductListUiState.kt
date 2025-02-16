package nextstep.shoppingcart.ui.theme.shopping.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
sealed interface ProductListUiState {

    @Immutable
    data object Loading : ProductListUiState

    @Immutable
    data object Empty : ProductListUiState

    @Immutable
    data object Error : ProductListUiState


    @Immutable
    data class Products(
        val products: List<Product>,
    ) : ProductListUiState
}
