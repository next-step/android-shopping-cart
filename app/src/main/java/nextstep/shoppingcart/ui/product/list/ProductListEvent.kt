package nextstep.shoppingcart.ui.product.list

sealed interface ProductListEvent {
    data class OnProductCardClick(
        val productId: Long,
    ) : ProductListEvent

    data object OnCartClick : ProductListEvent
}
