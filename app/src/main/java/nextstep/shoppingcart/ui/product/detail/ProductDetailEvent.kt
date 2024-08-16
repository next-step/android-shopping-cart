package nextstep.shoppingcart.ui.product.detail

import nextstep.shoppingcart.domain.model.Product

sealed interface ProductDetailEvent {
    data class OnApplyCartClick(
        val product: Product,
    ) : ProductDetailEvent
}
