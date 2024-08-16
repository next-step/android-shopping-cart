package nextstep.shoppingcart.ui.product.detail

import nextstep.shoppingcart.domain.model.Product

sealed interface ProductDetailEvent {
    data class AddToCart(
        val product: Product,
    ) : ProductDetailEvent
}
