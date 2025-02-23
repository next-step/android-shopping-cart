package nextstep.shoppingcart.model.detail

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import nextstep.shoppingcart.model.Product

@Stable
sealed interface ProductDetailUiState {

    @Immutable
    data object Loading : ProductDetailUiState

    @Immutable
    data object Empty : ProductDetailUiState

    @Immutable
    data object Error : ProductDetailUiState

    @Immutable
    data class ProductDetail(
        val product: Product,
    ) : ProductDetailUiState
}
