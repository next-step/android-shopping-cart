package nextstep.shoppingcart.ui.basket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.ui.model.Product

@Parcelize
data class BasketState(
    val isInitialLoading: Boolean = true,
    val isLoadingShow: Boolean = false,
    val products: List<Product> = emptyList(),
) : Parcelable {
    val totalPrice: Int
        get() = products.sumOf { it.totalPrice }
}
