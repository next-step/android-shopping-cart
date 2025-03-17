package nextstep.shoppingcart.productlist.model

import nextstep.shoppingcart.model.Product

data class ProductWithCartInfo(
    val product: Product,
    val cartCount: Int = 0
)
