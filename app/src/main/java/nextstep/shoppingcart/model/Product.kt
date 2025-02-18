package nextstep.shoppingcart.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val imageUrl: String,
    val name: String,
    val price: Int,
): Parcelable
