package nextstep.shoppingcart.ui.shoppingcart.model

import androidx.compose.runtime.Stable
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Stable
data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Long get() = product.price * count
}
