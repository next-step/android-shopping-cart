package nextstep.shoppingcart.ui.product.list

import nextstep.shoppingcart.domain.model.Product

sealed interface ProductListEvent {
    data class OnProductCardClick(
        val productId: Long,
    ) : ProductListEvent

    data object OnCartClick : ProductListEvent

    data class OnAddToCartClick(
        val product: Product,
    ) : ProductListEvent

    data class OnAddQuantityClick(
        val product: Product,
    ) : ProductListEvent

    data class OnRemoveQuantityClick(
        val product: Product,
    ) : ProductListEvent
}
