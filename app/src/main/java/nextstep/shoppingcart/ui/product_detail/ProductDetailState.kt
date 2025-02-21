package nextstep.shoppingcart.ui.product_detail

import nextstep.shoppingcart.ui.model.Product

data class ProductDetailState(
    val product: Product = Product("", "", "", 0),
    val isAddingToCart: Boolean = false,
)
