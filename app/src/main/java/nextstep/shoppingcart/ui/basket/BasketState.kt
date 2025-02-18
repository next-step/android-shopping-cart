package nextstep.shoppingcart.ui.basket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BasketState(
    val isInitialLoading: Boolean = true,
): Parcelable
