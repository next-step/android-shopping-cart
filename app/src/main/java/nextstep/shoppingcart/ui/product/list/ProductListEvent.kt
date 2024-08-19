package nextstep.shoppingcart.ui.product.list

import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.ProductItem

sealed interface ProductListEvent {
    data class OnProductCardClick(
        val productId: Long,
    ) : ProductListEvent

    data object OnCartClick : ProductListEvent

    data class OnAddToCartClick(
        val product: Product,
    ) : ProductListEvent

    data class OnAddQuantityClick(
        val productItem: ProductItem,
    ) : ProductListEvent

    data class OnRemoveQuantityClick(
        val productItem: ProductItem,
    ) : ProductListEvent
}
