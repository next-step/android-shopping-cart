package nextstep.shoppingcart.ui.product.list

sealed interface ProductListEvent {
    data class NavigateToProductDetail(
        val productId: Long,
    ) : ProductListEvent

    data object NavigateToCart : ProductListEvent
}
