package nextstep.shoppingcart.ui.basket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.model.CartItem

@Parcelize
data class BasketState(
    val cartItems: List<CartItem> = emptyList(),
): Parcelable
