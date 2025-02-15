package nextstep.shoppingcart.ui.product_list

import nextstep.shoppingcart.model.Product

data class ProductListState(
    val products: List<Product> = emptyList(),
    val selectedItemCount: Int = 0,
)
