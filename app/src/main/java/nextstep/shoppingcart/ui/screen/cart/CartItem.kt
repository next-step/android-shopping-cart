package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.runtime.Stable
import nextstep.shoppingcart.ui.screen.products.model.ProductModel

@Stable
data class CartItem(
    val product: ProductModel,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}
