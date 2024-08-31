package nextstep.shoppingcart.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val imageUrl: String,
    val price: Long,
) : Parcelable
