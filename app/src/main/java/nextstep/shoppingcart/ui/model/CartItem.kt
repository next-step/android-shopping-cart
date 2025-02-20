package nextstep.shoppingcart.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItem(
    val product: Product,
    val count: Int,
): Parcelable {
    val totalPrice: Int get() = product.price * count
}
