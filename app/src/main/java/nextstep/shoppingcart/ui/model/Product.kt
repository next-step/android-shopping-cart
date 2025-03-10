package nextstep.shoppingcart.ui.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val cartQuantity: Int,
) : Parcelable {
    @IgnoredOnParcel
    val totalPrice: Int = price * cartQuantity
}
