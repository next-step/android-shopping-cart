package nextstep.shoppingcart.ui.basket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.ui.model.CartItem

@Parcelize
data class BasketState(
    val isInitialLoading: Boolean = true,
    val isLoadingShow: Boolean = false,
    val cartItems: List<CartItem> = emptyList(),
) : Parcelable {
    val totalPrice: Int
        get() = cartItems.sumOf { it.totalPrice }
}
